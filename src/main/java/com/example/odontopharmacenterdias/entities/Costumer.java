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

    private String Name; // Full name of the customer. (String)

    @Column(name = "birth_day")
    private Date birthDay; // Customer's date of birth. (Date)

    private String cpf; // Brazilian Social Security Number (CPF) of the customer. (String)

    private String address; // Complete address of the customer (street, number, neighborhood, city, state, ZIP code). (String)

    private String phone; // Customer's phone number. (String)

    private String health_insurance; // Name of the customer's health insurance plan (SUS and/or other if applicable). (String)



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
