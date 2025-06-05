package com.example.healthcaresystem.clinic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
