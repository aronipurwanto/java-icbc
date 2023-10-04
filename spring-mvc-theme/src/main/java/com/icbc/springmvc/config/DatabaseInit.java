package com.icbc.springmvc.config;

import com.icbc.springmvc.entity.AssessmentEntity;
import com.icbc.springmvc.entity.AssessmentOptionEntity;
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
