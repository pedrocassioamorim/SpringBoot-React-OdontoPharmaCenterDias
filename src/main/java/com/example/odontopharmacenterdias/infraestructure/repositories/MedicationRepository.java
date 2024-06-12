package com.example.odontopharmacenterdias.infraestructure.repositories;

import com.example.odontopharmacenterdias.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {}
