package com.icbc.springmvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_assessment_option")
public class AssessmentOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "OPTION_NAME", length = 128)
    private String optionName;

    @Column(name = "OPTION_VALUE")
    private Double optionValue;

    @Column(name = "ASSESSMENT_ID", insertable = false, updatable = false)
    private Long assessmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ASSESSMENT_ID")
    private Assessment assessment;

    public AssessmentOption(String optionName, Double optionValue, Assessment assessment) {
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.assessment = assessment;
    }
}
