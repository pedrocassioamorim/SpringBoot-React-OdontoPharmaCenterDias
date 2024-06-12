package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Dentist;
import com.example.odontopharmacenterdias.entities.Gender;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
public class DentistDTO implements Serializable {
    Long id;
    String name;
    String cro;
    Gender gender;
    String speciality;
    String officeHours;
    String email;
    String phone;
    String address;


    public DentistDTO getDTOfromEntity (Dentist dentist){
        DentistDTO dto = new DentistDTO();
        dto.id = dentist.getId();
        dto.name = dentist.getName();
        dto.cro = dentist.getCro();
        dto.gender = dentist.getGender();
        dto.speciality = dentist.getSpeciality();
        dto.officeHours = dentist.getOfficeHours();
        dto.email = dentist.getEmail();
        dto.phone = dentist.getPhone();
        dto.address = dentist.getAddress();
        return dto;
    }


}