package com.scholartrack.service;

import com.scholartrack.entity.*;
import com.scholartrack.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository appRepo;
    private final StudentRepository studentRepo;
    private final SchemeRepository schemeRepo;

    public ApplicationService(ApplicationRepository appRepo, StudentRepository studentRepo, SchemeRepository schemeRepo){
        this.appRepo=appRepo; this.studentRepo=studentRepo; this.schemeRepo=schemeRepo;
    }

    public List<Application> all(){ return appRepo.findAll(); }
    public Application get(Long id){ return appRepo.findById(id).orElseThrow(() -> new RuntimeException("Application not found")); }

    public Application save(Application a){
        Student s = studentRepo.findById(a.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Scheme scheme = schemeRepo.findById(a.getSchemeId())
                .orElseThrow(() -> new RuntimeException("Scheme not found"));

        if(s.getAnnualIncome() > scheme.getIncomeLimit() || s.getMarks() < scheme.getMinimumMarks()){
            a.setStatus("INELIGIBLE");
            a.setRemarks("Eligibility rule failed before manual review.");
        } else {
            a.setStatus("PENDING");
            a.setRemarks("Eligible. Waiting for verification.");
        }
        return appRepo.save(a);
    }

    public Application update(Long id, Application a){
        Application old=get(id);
        a.setId(old.getId());
        return save(a);
    }

    public void delete(Long id){ appRepo.deleteById(id); }
}
