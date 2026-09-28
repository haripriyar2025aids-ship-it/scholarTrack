package com.scholartrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Verification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private Long applicationId;
    @NotBlank private String status;
    private String remarks;

    public Verification() {}
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public Long getApplicationId(){ return applicationId; }
    public void setApplicationId(Long applicationId){ this.applicationId=applicationId; }
    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status=status; }
    public String getRemarks(){ return remarks; }
    public void setRemarks(String remarks){ this.remarks=remarks; }
}
