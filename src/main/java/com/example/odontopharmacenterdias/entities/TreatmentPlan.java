package com.example.odontopharmacenterdias.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TreatmentPlan implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // Primary key, unique identifier for each treatment plan. (Long)

    @ManyToOne
    private Costumer costumer; // Foreign key to the patients table, identifying the patient to which the plan belongs. (Long)

    @OneToOne
    private Dentist dentist; // Foreign key to the dentists table, identifying the dentist responsible for the plan. (Long)

    private Date creationDate; // Date the treatment plan was created. (Date)

    @OneToMany
    private List<Procedure> procedureList; // List of procedures included in the plan, with their respective costs. (List<Procedure>)

    private Double finalCost; // Getting the sum of the whole treatment.

    private String notes; // Relevant notes about the treatment plan. (String)

    @Column(name = "active_plan")
    private Boolean activePlan; // Is the Treatment Plan active currently. (Boolean)

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TreatmentPlan that = (TreatmentPlan) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
