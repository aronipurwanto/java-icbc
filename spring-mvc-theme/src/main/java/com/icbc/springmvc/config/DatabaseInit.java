package com.icbc.springmvc.config;

import com.icbc.springmvc.entity.Assessment;
import com.icbc.springmvc.entity.AssessmentOption;
import com.icbc.springmvc.entity.CategoryEntity;
import com.icbc.springmvc.repository.AssessmentRepo;
import com.icbc.springmvc.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
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

    @Override
    public void run(String... args) throws Exception {
        log.info("Database init is called ...!");
        initCategory();

        initAssessment();
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
        Assessment profile = new Assessment("P0001","Profile", category);
        try{
            assessmentRepo.save(profile);
            log.info("Education save success");
        }catch (Exception e){
            log.error("Editucation save failed, error: {}", e.getMessage());
        }

        Assessment education = new Assessment("P0002","Pendidikan", profile, category);
        education.addOption(new AssessmentOption("SD",1.0, education));
        education.addOption(new AssessmentOption("SMP",1.0, education));
        education.addOption(new AssessmentOption("SMA",1.0, education));
        education.addOption(new AssessmentOption("D1",1.0, education));
        education.addOption(new AssessmentOption("D2",1.0, education));
        education.addOption(new AssessmentOption("D3",1.0, education));
        education.addOption(new AssessmentOption("D4",1.0, education));
        education.addOption(new AssessmentOption("S1",1.0, education));
        education.addOption(new AssessmentOption("S2",1.0, education));
        education.addOption(new AssessmentOption("S3",1.0, education));

        Assessment religion = new Assessment("P0003","Agama", profile, category);
        religion.addOption(new AssessmentOption("ISLAM",1.0, religion));
        religion.addOption(new AssessmentOption("KHATOLIK",1.0, religion));
        religion.addOption(new AssessmentOption("KRISTEN",1.0, religion));
        religion.addOption(new AssessmentOption("HINDU",1.0, religion));
        religion.addOption(new AssessmentOption("BUDHA",1.0, religion));
        religion.addOption(new AssessmentOption("KONG HU CHU",1.0, religion));

        Assessment gd = new Assessment("P0004","Golongan Darah", profile, category);
        gd.addOption(new AssessmentOption("A",1.0, gd));
        gd.addOption(new AssessmentOption("B",1.0, gd));
        gd.addOption(new AssessmentOption("AB",1.0, gd));
        gd.addOption(new AssessmentOption("O",1.0, gd));

        try{
            List<Assessment> assessments = Arrays.asList(education, religion, gd);
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
