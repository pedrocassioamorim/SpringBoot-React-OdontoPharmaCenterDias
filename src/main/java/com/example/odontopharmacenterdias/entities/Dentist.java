package com.example.odontopharmacenterdias.entities;

import com.example.odontopharmacenterdias.entities.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity @Data
public class Dentist implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // Primary key, unique identifier for each dentist. (Long)

    @Column(nullable = false)
    private String name; // Full name of the dentist. (String)

    @Column(nullable = false, unique = true)
    private String cro; // Brazilian Dental Council (CRO) number of the dentist. (String)

    @Enumerated(EnumType.STRING)
    private Gender gender; // Dentist's gender (male, female, other). (Enum/String)

    private String speciality; // Dental specialty of the dentist (general dentistry, orthodontics, periodontics, etc.). (String)

    @Column(name = "office_hours")
    private String officeHours; // Dentist's office hours at the clinic. (String)

    private String email; // Dentist's email address. (String)

    private String phone; // Dentist's phone number. (String)

    private String address; // Dentist's address. (String)

}
