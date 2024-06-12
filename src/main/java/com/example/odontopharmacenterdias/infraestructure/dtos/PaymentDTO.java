package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Payment;
import com.example.odontopharmacenterdias.entities.enums.PaymentMethod;
import com.example.odontopharmacenterdias.entities.Procedure;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class PaymentDTO implements Serializable {

    Long id;
    CostumerDTO costumer;
    TreatmentPlanDTO treatmentPlan;
    List<ProcedureDTO> procedureList;
    Double total;
    PaymentMethod paymentMethod;
    Date paymentDate;
    String paymentReceipt;

    public PaymentDTO getDTOfromEntity(Payment payment){
        PaymentDTO dto = new PaymentDTO();
        dto.id = payment.getId();
        dto.costumer = new CostumerDTO().getDTOfromEntity(payment.getCostumer());
        dto.treatmentPlan = new TreatmentPlanDTO().getDTOfromEntity(payment.getTreatmentPlan());
        dto.procedureList = convertListProcedures(payment.getProcedureList());
        dto.total = payment.getTotal();
        dto.paymentMethod = payment.getPaymentMethod();
        dto.paymentDate = payment.getPaymentDate();
        dto.paymentReceipt = payment.getPaymentReceipt();
        return dto;
    }

    public List<ProcedureDTO> convertListProcedures(List<Procedure> procedures){
        List<ProcedureDTO> dtos = new ArrayList<>();
        for (Procedure procedure : procedures){
            ProcedureDTO dto = new ProcedureDTO();
            dto.getDTOfromEntity(procedure);
            dtos.add(dto);
        }
        return dtos;
    }

}
