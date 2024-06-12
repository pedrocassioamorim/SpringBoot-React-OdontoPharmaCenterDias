package com.example.odontopharmacenterdias.infraestructure.repositories;

import com.example.odontopharmacenterdias.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {}
