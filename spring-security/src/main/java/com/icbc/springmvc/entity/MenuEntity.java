package com.icbc.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_menu")
public class MenuEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MENU_NAME", length = 64, nullable = false, unique = true)
    private String name;

    @Column(name = "MENU_TITLE", length = 100, nullable = false)
    private String title;

    @Column(name = "MENU_URL", length = 200, nullable = false)
    private String url;

    @Column(name = "MENU_DESC", length = 200)
    private String description;

    @Column(name = "MENU_ICON", length = 100)
    private String icon;

    @Column(name = "MENU_PARAM", length = 100)
    private String params;
    @Column(name="position")
    private Integer position;

    @Column(name = "PARENT_ID", insertable = false, updatable = false)
    private String parentId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MenuEntity parentMenu;

    @JsonIgnore
    @OneToMany(mappedBy = "parentMenu")
    private List<MenuEntity> subMenu = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "menus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleEntity> roles = new ArrayList<>();

    public MenuEntity(String name, String title, String url, String description, String icon, Integer position, String params, MenuEntity parentMenu) {
        this.name = name;
        this.title = title;
        this.url = url;
        this.description = description;
        this.icon = icon;
        this.params = params;
        this.position = position;
        this.parentMenu = parentMenu;
    }

    public void addSubMenu(MenuEntity menuEntity){
        this.subMenu.add(menuEntity);
        menuEntity.setParentMenu(this);
    }

    public void removeSubMenu(MenuEntity menuEntity){
        this.subMenu.remove(menuEntity);
        menuEntity.setParentMenu(null);
    }
}
