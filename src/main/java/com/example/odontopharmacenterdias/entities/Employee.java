package com.example.odontopharmacenterdias.entities;

import com.example.odontopharmacenterdias.entities.enums.Gender;
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
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // Primary key, unique identifier for each employee. (Long)

    @Column(nullable = false)
    private String name; // Full name of the employee. (String)

    private Date birthDay; // Employee's date of birth. (Date)

    @Column(unique = true, nullable = false)
    private String cpf; // Brazilian Social Security Number (CPF) of the employee. (String)

    @Enumerated(EnumType.STRING)
    private Gender gender; // Employee's gender (male, female, other). (Enum/String)

    private String maritalStatus; // Employee's marital status (single, married, divorced, widowed). (String)

    private String address; //  Complete address of the employee (street, number, neighborhood, city, state, ZIP code). (String)

    private String phone; // Employee's phone number. (String)

    private String position; // Employee's position in the pharmacy (manager, pharmacist, cashier, etc.). (String)

    private Date admissionDate; // Employee's admission date to the pharmacy. (Date)

    private Date firingDate; // Employee's firing date to the pharmacy. (Date)

    private Double salary; // Employee's salary. (Decimal)

    private Boolean active; // Is currently a Employee of the pharmacy. (Boolean)


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Employee employee = (Employee) o;
        return getId() != null && Objects.equals(getId(), employee.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
