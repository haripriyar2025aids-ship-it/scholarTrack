package com.scholartrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Disbursement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private Long applicationId;
    private String status;
    private String transactionRef;

    public Disbursement() {}
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }
    public Long getApplicationId(){ return applicationId; }
    public void setApplicationId(Long applicationId){ this.applicationId=applicationId; }
    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status=status; }
    public String getTransactionRef(){ return transactionRef; }
    public void setTransactionRef(String transactionRef){ this.transactionRef=transactionRef; }
}
