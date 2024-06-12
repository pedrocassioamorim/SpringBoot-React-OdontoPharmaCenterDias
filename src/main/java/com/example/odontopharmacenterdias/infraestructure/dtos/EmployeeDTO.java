package com.example.odontopharmacenterdias.infraestructure.dtos;

import com.example.odontopharmacenterdias.entities.Employee;
import com.example.odontopharmacenterdias.entities.enums.Gender;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EmployeeDTO implements Serializable {
    Long id;
    String name;
    Date birthDay;
    String cpf;
    Gender gender;
    String maritalStatus;
    String address;
    String phone;
    String position;
    Date admissionDate;
    Date firingDate;
    Double salary;
    Boolean active;

    public EmployeeDTO getDTOfromEntity(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.id = employee.getId();
        dto.name = employee.getName();
        dto.birthDay = employee.getBirthDay();
        dto.cpf = employee.getCpf();
        dto.gender = employee.getGender();
        dto.maritalStatus = employee.getMaritalStatus();
        dto.address = employee.getAddress();
        dto.phone = employee.getPhone();
        dto.position = employee.getPosition();
        dto.admissionDate = employee.getAdmissionDate();
        dto.firingDate = employee.getFiringDate();
        dto.salary = employee.getSalary();
        dto.active = employee.getActive();
        return dto;
    }
}
