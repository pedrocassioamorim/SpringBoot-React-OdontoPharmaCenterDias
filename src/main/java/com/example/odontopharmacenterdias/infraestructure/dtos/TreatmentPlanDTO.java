package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Procedure;
import com.example.odontopharmacenterdias.entities.TreatmentPlan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreatmentPlanDTO {
    Long id;
    CostumerDTO costumer;
    DentistDTO dentist;
    Date creationDate;
    List<ProcedureDTO> procedureList;
    Double finalCost;
    String notes;
    Boolean activePlan;

    public TreatmentPlanDTO getDTOfromEntity(TreatmentPlan plan){
        TreatmentPlanDTO dto = new TreatmentPlanDTO();
        dto.id = plan.getId();
        dto.costumer = new CostumerDTO().getDTOfromEntity(plan.getCostumer());
        dto.dentist = new DentistDTO().getDTOfromEntity(plan.getDentist());
        dto.creationDate = plan.getCreationDate();
        dto.procedureList = convertListProcedures(plan.getProcedureList());
        dto.finalCost = plan.getFinalCost();
        dto.notes = plan.getNotes();
        dto.activePlan = plan.getActivePlan();
        return dto;
    }

    public List<ProcedureDTO> convertListProcedures(List<Procedure> procedures){
        List<ProcedureDTO> dtos = new ArrayList<>();
        for (Procedure procedure : procedures){
            ProcedureDTO dto = new ProcedureDTO();
            dto = dto.getDTOfromEntity(procedure);
            dtos.add(dto);
        }
        return dtos;
    }

}
