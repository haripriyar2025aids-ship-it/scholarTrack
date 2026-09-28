package com.scholartrack.repository;

import com.scholartrack.entity.Disbursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisbursementRepository extends JpaRepository<Disbursement, Long> {
}
