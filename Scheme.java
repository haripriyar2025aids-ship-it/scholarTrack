package com.scholartrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Scheme {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank private String name;
    @Positive private double incomeLimit;
    @PositiveOrZero private double minimumMarks;
    @Positive private double amount;

    public Scheme() {}
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }
    public double getIncomeLimit(){ return incomeLimit; }
    public void setIncomeLimit(double incomeLimit){ this.incomeLimit=incomeLimit; }
    public double getMinimumMarks(){ return minimumMarks; }
    public void setMinimumMarks(double minimumMarks){ this.minimumMarks=minimumMarks; }
    public double getAmount(){ return amount; }
    public void setAmount(double amount){ this.amount=amount; }
}
