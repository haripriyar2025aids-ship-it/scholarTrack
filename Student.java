package com.scholartrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank private String name;
    @NotBlank private String registerNo;
    @NotBlank private String department;
    @Email @NotBlank private String email;
    @PositiveOrZero private double annualIncome;
    @PositiveOrZero private double marks;

    public Student() {}
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }
    public String getRegisterNo(){ return registerNo; }
    public void setRegisterNo(String registerNo){ this.registerNo=registerNo; }
    public String getDepartment(){ return department; }
    public void setDepartment(String department){ this.department=department; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email=email; }
    public double getAnnualIncome(){ return annualIncome; }
    public void setAnnualIncome(double annualIncome){ this.annualIncome=annualIncome; }
    public double getMarks(){ return marks; }
    public void setMarks(double marks){ this.marks=marks; }
}
