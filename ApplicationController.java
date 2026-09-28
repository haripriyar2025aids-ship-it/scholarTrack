package com.scholartrack.controller;

import com.scholartrack.entity.Application;
import com.scholartrack.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/application")
@CrossOrigin(origins = "http://localhost:5173")
public class ApplicationController {
    private final ApplicationService service;
    public ApplicationController(ApplicationService service){ this.service=service; }

    @GetMapping
    public List<Application> all(){ return service.all(); }

    @GetMapping("/{id}")
    public Application get(@PathVariable Long id){ return service.get(id); }

    @PostMapping
    public Application create(@Valid @RequestBody Application item){ return service.save(item); }

    @PutMapping("/{id}")
    public Application update(@PathVariable Long id, @Valid @RequestBody Application item){ return service.update(id,item); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.delete(id); return ResponseEntity.noContent().build(); }
}
