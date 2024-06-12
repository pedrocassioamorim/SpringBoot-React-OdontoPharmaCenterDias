package com.example.odontopharmacenterdias.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Procedure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // Primary key, unique identifier for each procedure. (Long)

    private String name; // Complete name of the dental procedure. (String)

    private String description; // Complete description of the dental procedure. (String)

    @Column(name = "procedure_code")
    private String procedureCode; // Procedure code according to the dental procedure table (TUSS). (String)

    private String speciality; // Dental specialty related to the procedure. (String)

    private Double cost; // Cost of the procedure. (Decimal)

    @Column(name = "date_of_procedure")
    private Date dateOfProcedure; // Date of procedure. (Date)

    private Boolean isPaid; // Is the Procedure already paid? (Boolean)


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Procedure procedure = (Procedure) o;
        return getId() != null && Objects.equals(getId(), procedure.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
