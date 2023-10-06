package com.icbc.springmvc.config;

import com.icbc.springmvc.entity.*;
import com.icbc.springmvc.repository.AssessmentRepo;
import com.icbc.springmvc.repository.CategoryRepo;
import com.icbc.springmvc.repository.RoleRepo;
import com.icbc.springmvc.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseInit implements CommandLineRunner {
    private final CategoryRepo categoryRepo;
    private final AssessmentRepo assessmentRepo;
    private final PasswordEncoder encoder;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        log.info("Database init is called ...!");
        initCategory();
        // generate Assessment
        initAssessment();
        // generate role
        initRole();
        // generate user
        initUser();
    }

    private void initRole(){
        if(roleRepo.count() > 0){
            return;
        }

        try {
            roleRepo.saveAll(List.of(
                    new RoleEntity("ROLE_ADMIN"),
                    new RoleEntity("ROLE_USER"),
                    new RoleEntity("ROLE_SUPER_USER")
            ));
            log.info("Save role success..!");
        }catch (Exception e){
            log.error("Save role failed, error: {}", e.getMessage());
        }
    }

    private void initUser(){
        if(userRepo.count() > 0){
            return;
        }

        // admin
        RoleEntity adminRole = roleRepo.findByName("ROLE_ADMIN").orElse(null);
        if(adminRole != null){
            UserEntity admin = new UserEntity("Admin","User","admin@gmail.com", encoder.encode("P@ssW0rd32!"),List.of(adminRole));
            try {
                userRepo.save(admin);
                log.info("Create admin role success..!");
            }catch (Exception e){
                log.error("Create admin role failed, Error: {}", e.getMessage());
            }
        }

        // user
        RoleEntity userRole = roleRepo.findByName("ROLE_USER").orElse(null);
        if(adminRole != null){
            UserEntity user = new UserEntity("User","Role","user@gmail.com", encoder.encode("P@ssW0rd32!"),List.of(userRole));
            try {
                userRepo.save(user);
                log.info("Create user role success..!");
            }catch (Exception e){
                log.error("Create user role failed, Error: {}", e.getMessage());
            }
        }

        // super user
        RoleEntity superUserRole = roleRepo.findByName("ROLE_SUPER_USER").orElse(null);
        if(superUserRole != null){
            UserEntity superUser = new UserEntity("Super","User","super.user@gmail.com", encoder.encode("P@ssW0rd32!"),List.of(superUserRole));
            try {
                userRepo.save(superUser);
                log.info("Create super user role success..!");
            }catch (Exception e){
                log.error("Create super user role failed, Error: {}", e.getMessage());
            }
        }
    }

    private void initAssessment(){
        if(assessmentRepo.count() > 0L){
            log.info("Assessment is exist..!");
            return;
        }

        CategoryEntity category = categoryRepo.findByName("CUSTOMER_ASSESSMENT").orElse(null);
        if(category == null){
            return;
        }
        AssessmentEntity profile = new AssessmentEntity("P0001","Profile", category);
        try{
            assessmentRepo.save(profile);
            log.info("Education save success");
        }catch (Exception e){
            log.error("Editucation save failed, error: {}", e.getMessage());
        }

        AssessmentEntity education = new AssessmentEntity("P0002","Pendidikan", profile, category);
        education.addOption(new AssessmentOptionEntity("SD",1.0, education));
        education.addOption(new AssessmentOptionEntity("SMP",1.0, education));
        education.addOption(new AssessmentOptionEntity("SMA",1.0, education));
        education.addOption(new AssessmentOptionEntity("D1",1.0, education));
        education.addOption(new AssessmentOptionEntity("D2",1.0, education));
        education.addOption(new AssessmentOptionEntity("D3",1.0, education));
        education.addOption(new AssessmentOptionEntity("D4",1.0, education));
        education.addOption(new AssessmentOptionEntity("S1",1.0, education));
        education.addOption(new AssessmentOptionEntity("S2",1.0, education));
        education.addOption(new AssessmentOptionEntity("S3",1.0, education));

        AssessmentEntity religion = new AssessmentEntity("P0003","Agama", profile, category);
        religion.addOption(new AssessmentOptionEntity("ISLAM",1.0, religion));
        religion.addOption(new AssessmentOptionEntity("KHATOLIK",1.0, religion));
        religion.addOption(new AssessmentOptionEntity("KRISTEN",1.0, religion));
        religion.addOption(new AssessmentOptionEntity("HINDU",1.0, religion));
        religion.addOption(new AssessmentOptionEntity("BUDHA",1.0, religion));
        religion.addOption(new AssessmentOptionEntity("KONG HU CHU",1.0, religion));

        AssessmentEntity gd = new AssessmentEntity("P0004","Golongan Darah", profile, category);
        gd.addOption(new AssessmentOptionEntity("A",1.0, gd));
        gd.addOption(new AssessmentOptionEntity("B",1.0, gd));
        gd.addOption(new AssessmentOptionEntity("AB",1.0, gd));
        gd.addOption(new AssessmentOptionEntity("O",1.0, gd));

        try{
            List<AssessmentEntity> assessments = Arrays.asList(education, religion, gd);
            this.assessmentRepo.saveAll(assessments);
            log.info("Save All assessment success..!");
        }catch (Exception e){
            log.error("Save All assessment failed, error: {}", e.getMessage());
        }
    }

    private void initCategory(){
        if(categoryRepo.count() > 0L){
            log.info("Category is exist..!");
            return;
        }

        List<CategoryEntity> categories = new ArrayList<>();
        categories.add(new CategoryEntity(0L,"CUSTOMER_ASSESSMENT"));
        categories.add(new CategoryEntity(0L,"EMPLOYEE_ASSESSMENT"));
        categories.add(new CategoryEntity(0L,"PRODUCT_ASSESSMENT"));

        try{
            this.categoryRepo.saveAll(categories);
            log.info("Category save successfully");
        }catch (Exception e){
            log.error("Category save is failed, error: {}", e.getMessage());
        }
    }
}
