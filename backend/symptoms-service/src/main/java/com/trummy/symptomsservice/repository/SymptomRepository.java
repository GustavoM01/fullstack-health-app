package com.trummy.symptomsservice.repository;

import com.trummy.symptomsservice.dao.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {

    List<Symptom> findByUserId(Long userId);
}
