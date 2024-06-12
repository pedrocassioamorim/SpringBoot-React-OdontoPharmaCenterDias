package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Costumer;
import com.example.odontopharmacenterdias.entities.Gender;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

@Data
public class CostumerDTO implements Serializable {
    Long id;
    String name;
    Date birthDay;
    String cpf;
    String rg;
    Gender gender;
    String address;
    String phone;
    String email;
    String maritalStatus;
    String ocupation;
    String health_insurance;
    String allergies;
    String medicationsUsed;
    String medicalHistory;
    String dentalClinicalChart;
    String notes;

    public CostumerDTO getDTOfromEntity (Costumer costumer){
        CostumerDTO dto = new CostumerDTO();
        dto.id = costumer.getId();
        dto.name = costumer.getName();
        dto.birthDay = costumer.getBirthDay();
        dto.cpf = costumer.getCpf();
        dto.rg = costumer.getRg();
        dto.gender = costumer.getGender();
        dto.address = costumer.getAddress();
        dto.phone = costumer.getPhone();
        dto.email = costumer.getEmail();
        dto.maritalStatus = costumer.getMaritalStatus();
        dto.ocupation = costumer.getOcupation();
        dto.health_insurance = costumer.getHealth_insurance();
        dto.allergies = costumer.getAllergies();
        dto.medicationsUsed = costumer.getMedicationsUsed();
        dto.medicalHistory = costumer.getMedicalHistory();
        dto.dentalClinicalChart = costumer.getDentalClinicalChart();
        dto.notes = costumer.getNotes();
        return dto;
    }
}