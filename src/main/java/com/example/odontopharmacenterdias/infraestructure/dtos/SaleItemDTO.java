package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Medication;
import com.example.odontopharmacenterdias.entities.SaleItem;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class SaleItemDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    MedicationDTO medication;
    Integer quantity;
    Double unitPrice;
    Double totalPrice;

    public SaleItemDTO getDTOfromEntity(SaleItem saleItem){
        SaleItemDTO dto = new SaleItemDTO();
        dto.id = saleItem.getId();
        dto.medication = getMedicationDTO(saleItem.getMedication());
        dto.quantity = saleItem.getQuantity();
        dto.unitPrice = saleItem.getUnitPrice();
        dto.totalPrice = saleItem.getTotalPrice();
        return dto;
    }

    static MedicationDTO getMedicationDTO(Medication medication) {
        return getMedicationDTO(medication);
    }
}
