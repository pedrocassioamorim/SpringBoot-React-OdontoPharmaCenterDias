package com.example.odontopharmacenterdias.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Costumer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // Primary key, unique identifier for each customer. (Long)

    @Column(nullable = false)
    private String name; // Full name of the customer. (String)

    @Column(name = "birth_day")
    private Date birthDay; // Customer's date of birth. (Date)

    @Column(nullable = false, unique = true)
    private String cpf; // Brazilian Social Security Number (CPF) of the customer. (String)

    private String rg; // Brazilian Identity Card (RG) number of the patient. (String)

    @Enumerated(EnumType.STRING)
    private Gender gender; // Patient's gender (male, female, other). (Enum/String)

    private String address; // Complete address of the customer (street, number, neighborhood, city, state, ZIP code). (String)

    private String phone; // Customer's phone number. (String)

    private String email; // Patient's email address. (String)

    private String maritalStatus; // Patient's marital status (single, married, divorced, widowed). (String)

    private String ocupation; // Patient's occupation. (String)

    private String health_insurance; // Name of the customer's health insurance plan (SUS and/or other if applicable). (String)

    private String allergies; // List of patient's allergies (if any). (String)

    @Column(name = "medications_used")
    private String medicationsUsed; // List of medications the patient is using (if any). (String)

    @Column(name = "medical_history")
    private String medicalHistory; // Patient's medical history. (String)

    @Column(name = "dental_clinical_chart")
    private String dentalClinicalChart; // Patient's dental clinical chart (String)

    private String notes; // Relevant notes about the patient. (String)



    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Costumer costumer = (Costumer) o;
        return getId() != null && Objects.equals(getId(), costumer.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
