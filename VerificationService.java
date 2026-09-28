package com.scholartrack.service;

import com.scholartrack.entity.Verification;
import com.scholartrack.entity.Application;
import com.scholartrack.repository.VerificationRepository;
import com.scholartrack.repository.ApplicationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VerificationService {
    private final VerificationRepository repo;
    private final ApplicationRepository appRepo;

    public VerificationService(VerificationRepository repo, ApplicationRepository appRepo){
        this.repo=repo; this.appRepo=appRepo;
    }

    public List<Verification> all(){ return repo.findAll(); }
    public Verification get(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Verification not found")); }

    public Verification save(Verification v){
        Application app = appRepo.findById(v.getApplicationId())
                .orElseThrow(() -> new RuntimeException("Application not found"));
        if("INELIGIBLE".equalsIgnoreCase(app.getStatus()))
            throw new RuntimeException("Ineligible application cannot be manually approved.");
        if("APPROVED".equalsIgnoreCase(v.getStatus()))
            app.setStatus("VERIFICATION_APPROVED");
        else if("REJECTED".equalsIgnoreCase(v.getStatus()))
            app.setStatus("REJECTED");
        appRepo.save(app);
        return repo.save(v);
    }

    public Verification update(Long id, Verification v){
        Verification old=get(id);
        v.setId(old.getId());
        return save(v);
    }
    public void delete(Long id){ repo.deleteById(id); }
}
