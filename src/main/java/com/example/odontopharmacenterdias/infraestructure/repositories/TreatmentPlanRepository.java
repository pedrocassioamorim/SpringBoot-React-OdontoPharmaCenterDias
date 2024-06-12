package com.example.odontopharmacenterdias.infraestructure.repositories;

import com.example.odontopharmacenterdias.entities.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Long> {}
