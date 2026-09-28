package com.scholartrack.service;

import com.scholartrack.entity.Scheme;
import com.scholartrack.repository.SchemeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchemeService {
    private final SchemeRepository repo;
    public SchemeService(SchemeRepository repo){ this.repo=repo; }
    public List<Scheme> all(){ return repo.findAll(); }
    public Scheme get(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Scheme not found")); }
    public Scheme save(Scheme s){ return repo.save(s); }
    public Scheme update(Long id, Scheme s){ Scheme old=get(id); s.setId(old.getId()); return repo.save(s); }
    public void delete(Long id){ repo.deleteById(id); }
}
