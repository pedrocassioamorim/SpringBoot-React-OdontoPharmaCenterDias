package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.*;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDTO {

    Long id;
    Date timestamp;
    CostumerDTO costumer;
    DentistDTO dentist;
    String speciality;
    StatusOfAppointment status;
    String notes;

    public AppointmentDTO(Appointment appointment){
        this.id = appointment.getId();
        this.timestamp = appointment.getTimestamp();
        this.costumer = new CostumerDTO().getDTOfromEntity(appointment.getCostumer());
        this.dentist = new DentistDTO().getDTOfromEntity(appointment.getDentist());
        this.speciality = appointment.getSpeciality();
        this.status = appointment.getStatus();
        this.notes = appointment.getNotes();

    }

}
