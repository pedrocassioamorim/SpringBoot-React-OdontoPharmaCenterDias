package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.SaleItem;

public class SaleItemDTO {
    Long id;
    MedicationDTO medication;
    Integer quantity;
    Double unitPrice;
    Double totalPrice;

    public SaleItemDTO getDTOfromEntity(SaleItem saleItem){
        SaleItemDTO dto = new SaleItemDTO();
        dto.id = saleItem.getId();
        dto.medication = new MedicationDTO();
        dto.quantity = saleItem.getQuantity();
        dto.unitPrice = saleItem.getUnitPrice();
        dto.totalPrice = saleItem.getTotalPrice();
        return dto;
    }
}
