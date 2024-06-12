package com.example.odontopharmacenterdias.infraestructure.repositories;

import com.example.odontopharmacenterdias.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {}
