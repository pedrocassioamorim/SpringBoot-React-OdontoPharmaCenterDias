package com.example.odontopharmacenterdias.infraestructure.repositories;

import com.example.odontopharmacenterdias.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {}
