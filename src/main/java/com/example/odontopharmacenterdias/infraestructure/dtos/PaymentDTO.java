package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Payment;
import com.example.odontopharmacenterdias.entities.enums.PaymentMethod;
import static com.example.odontopharmacenterdias.infraestructure.dtos.ProcedureDTO.getProcedureDTOfromEntity;
import static com.example.odontopharmacenterdias.infraestructure.dtos.TreatmentPlanDTO.getListProcedureDTO;
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
        dto.procedureList = getListProcedureDTO(payment.getProcedureList());
        dto.total = payment.getTotal();
        dto.paymentMethod = payment.getPaymentMethod();
        dto.paymentDate = payment.getPaymentDate();
        dto.paymentReceipt = payment.getPaymentReceipt();
        return dto;
    }


}
