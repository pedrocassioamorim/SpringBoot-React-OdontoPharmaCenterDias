package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Medication;
import lombok.Data;

import java.io.Serializable;


@Data
public class MedicationDTO implements Serializable {

    Long id;
    String name;
    String activeIngredient;
    String laboratory;
    String classification;
    String presentation;
    String composition;
    String unitOfMeasurement;
    Double costPrice;
    Double salePrice;
    Integer currentStock;
    Integer minimumStock;
    Boolean popularPharmacie;

    public static MedicationDTO getDTOfromEntity(Medication medication){
        MedicationDTO dto = new MedicationDTO();
        dto.id = medication.getId();
        dto.name = medication.getName();
        dto.activeIngredient = medication.getActiveIngredient();
        dto.laboratory = medication.getLaboratory();
        dto.classification = medication.getClassification();
        dto.presentation = medication.getPresentation();
        dto.composition = medication.getComposition();
        dto.unitOfMeasurement = medication.getUnitOfMeasurement();
        dto.costPrice = medication.getCostPrice();
        dto.salePrice = medication.getSalePrice();
        dto.currentStock = medication.getCurrentStock();
        dto.minimumStock = medication.getMinimumStock();
        dto.popularPharmacie = medication.getPopularPharmacie();
        return dto;
    }
}
