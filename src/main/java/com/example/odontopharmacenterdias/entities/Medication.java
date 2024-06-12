package com.example.odontopharmacenterdias.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Medication implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // Primary key, unique identifier for each medication. (Long)

    private String name; // Commercial name of the medication. (String)

    private String activeIngredient; // Chemical substance responsible for the pharmacological action of the medication. (String)

    private String laboratory; // Manufacturer of the medication. (String)

    private String classification; // Therapeutic category of the medication (e.g., analgesic, antibiotic). (String)

    private String presentation; // Pharmaceutical form of the medication (tablet, capsule, etc.). (String)

    private String composition; // Quantity and type of each active ingredient present in the medication. (String)

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement; // Unit in which the quantity of the medication is measured (mg, g, etc.). (String)

    @Column(name = "cost_price")
    private Double costPrice; // Purchase price of the medication for the pharmacy. (Decimal)

    @Column(name = "sale_price")
    private Double salePrice; // Sale price of the medication to the customer. (Decimal)

    @Column(name = "current_stock")
    private Integer currentStock; // Quantity of the medication in stock at the moment. (Integer)

    @Column(name = "minimum_stock")
    private Integer minimumStock; // Minimum stock quantity that must be maintained to avoid stockouts. (Integer)

    private Boolean popularPharmacie; // Medication is part of Popular Pharmacie Brazilian Aid Program

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Medication that = (Medication) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
