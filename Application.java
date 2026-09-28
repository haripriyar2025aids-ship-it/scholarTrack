package com.scholartrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "scholarship_applications")
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private Long studentId;
    @NotNull private Long schemeId;
    private String status;
    private String remarks;

    public Application() {}
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public Long getStudentId(){ return studentId; }
    public void setStudentId(Long studentId){ this.studentId=studentId; }
    public Long getSchemeId(){ return schemeId; }
    public void setSchemeId(Long schemeId){ this.schemeId=schemeId; }
    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status=status; }
    public String getRemarks(){ return remarks; }
    public void setRemarks(String remarks){ this.remarks=remarks; }
}
