package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Supplier;
import lombok.Data;

import java.io.Serializable;

@Data
public class SupplierDTO implements Serializable {

    Long id;
    String name;
    String cnpj;
    String address;
    String phone;
    String email;
    String website;
    String password;


    public SupplierDTO getDTOfromEntity(Supplier supplier){
        SupplierDTO dto = new SupplierDTO();
        dto.id = supplier.getId();
        dto.name = supplier.getName();
        dto.cnpj = supplier.getCnpj();
        dto.address = supplier.getAddress();
        dto.phone = supplier.getPhone();
        dto.email = supplier.getEmail();
        dto.website = supplier.getWebsite();
        dto.password = supplier.getPassword();
        return dto;
    }
}
