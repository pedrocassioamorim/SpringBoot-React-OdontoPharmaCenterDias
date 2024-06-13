package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Procedure;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class ProcedureDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    String name;
    String description;
    String procedureCode;
    String speciality;
    Double cost;
    Date dateOfProcedure;
    Boolean isPaid;

    public static ProcedureDTO getProcedureDTOfromEntity (Procedure procedure){
        ProcedureDTO dto = new ProcedureDTO();
        dto.id = procedure.getId();
        dto.name = procedure.getName();
        dto.description = procedure.getDescription();
        dto.procedureCode = procedure.getProcedureCode();
        dto.speciality = procedure.getSpeciality();
        dto.cost = procedure.getCost();
        dto.dateOfProcedure = procedure.getDateOfProcedure();
        dto.isPaid = procedure.getIsPaid();
        return dto;
    }


}
