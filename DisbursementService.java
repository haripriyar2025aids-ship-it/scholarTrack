package com.scholartrack.service;

import com.scholartrack.entity.*;
import com.scholartrack.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DisbursementService {
    private final DisbursementRepository repo;
    private final ApplicationRepository appRepo;
    private final VerificationRepository verificationRepo;

    public DisbursementService(DisbursementRepository repo, ApplicationRepository appRepo, VerificationRepository verificationRepo){
        this.repo=repo; this.appRepo=appRepo; this.verificationRepo=verificationRepo;
    }

    public List<Disbursement> all(){ return repo.findAll(); }
    public Disbursement get(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Disbursement not found")); }

    public Disbursement save(Disbursement d){
        Application app = appRepo.findById(d.getApplicationId())
                .orElseThrow(() -> new RuntimeException("Application not found"));
        boolean approved = verificationRepo.findAll().stream()
                .anyMatch(v -> v.getApplicationId().equals(d.getApplicationId())
                        && "APPROVED".equalsIgnoreCase(v.getStatus()));
        if(!approved)
            throw new RuntimeException("Disbursement cannot be completed until verification is approved.");
        d.setStatus("COMPLETED");
        return repo.save(d);
    }

    public Disbursement update(Long id, Disbursement d){
        Disbursement old=get(id);
        d.setId(old.getId());
        return save(d);
    }
    public void delete(Long id){ repo.deleteById(id); }
}
