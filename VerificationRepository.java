package com.scholartrack.repository;

import com.scholartrack.entity.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<Verification, Long> {
}
