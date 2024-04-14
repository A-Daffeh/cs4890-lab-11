package com.cs489.Lab7.repository;

import com.cs489.Lab7.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByOrderByLastNameAsc();

    @Query("SELECT p FROM Patient p WHERE lower(p.firstName) LIKE lower(concat('%', ?1, '%')) OR " +
            "lower(p.lastName) LIKE lower(concat('%', ?1, '%')) OR " +
            "lower(p.email) LIKE lower(concat('%', ?1, '%'))")
    List<Patient> searchByKeyword(String keyword);
}
