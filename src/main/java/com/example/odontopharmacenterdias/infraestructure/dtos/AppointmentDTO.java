package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.*;
import com.example.odontopharmacenterdias.entities.enums.StatusOfAppointment;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class AppointmentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    Date timestamp;
    CostumerDTO costumer;
    DentistDTO dentist;
    String speciality;
    StatusOfAppointment status;
    String notes;

    public AppointmentDTO getDTOfromEntity (Appointment appointment){
        AppointmentDTO dto = new AppointmentDTO();
        dto.id = appointment.getId();
        dto.timestamp = appointment.getTimestamp();
        dto.costumer = new CostumerDTO().getDTOfromEntity(appointment.getCostumer());
        dto.dentist = new DentistDTO().getDTOfromEntity(appointment.getDentist());
        dto.speciality = appointment.getSpeciality();
        dto.status = appointment.getStatus();
        dto.notes = appointment.getNotes();
        return dto;
    }

}
