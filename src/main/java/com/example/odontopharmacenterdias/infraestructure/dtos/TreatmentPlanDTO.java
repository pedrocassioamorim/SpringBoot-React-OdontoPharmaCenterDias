package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Procedure;
import com.example.odontopharmacenterdias.entities.TreatmentPlan;
import static com.example.odontopharmacenterdias.infraestructure.dtos.ProcedureDTO.getProcedureDTOfromEntity;
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
        dto.procedureList = getListProcedureDTO(plan.getProcedureList());
        dto.finalCost = plan.getFinalCost();
        dto.notes = plan.getNotes();
        dto.activePlan = plan.getActivePlan();
        return dto;
    }

    public static List<ProcedureDTO> getListProcedureDTO(List<Procedure> procedureList){
        List<ProcedureDTO> dtos = new ArrayList<ProcedureDTO>();
        for (Procedure proc : procedureList) {
            ProcedureDTO procedureDTO = getProcedureDTOfromEntity(proc);
            dtos.add(procedureDTO);
        }
        return dtos;
    }


}
