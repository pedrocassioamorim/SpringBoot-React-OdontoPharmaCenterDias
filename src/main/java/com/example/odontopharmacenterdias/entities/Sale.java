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
public class Sale implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // Primary key, unique identifier for each sale. (Long)

    @Column(name = "sale_date")
    private Date saleDate; // Date and time of the sale. (Date)

    @ManyToOne
    private Costumer costumer; // Foreign key to the customers table, identifying the customer who made the purchase. (Long)

    @ManyToOne
    private Employee employee; // Foreign key to the employees table, identifying the employee who served the customer. (Long)

    @ManyToMany
    private List<SaleItem> items; // List of sale items;

    private Double discount; // Discount value applied to the sale (if applicable). (Decimal)

    private Double totalAmount = items.stream()  // Total sale amount (sum of the total prices of the sale items - discount). (Decimal)
                                .mapToDouble(SaleItem::getTotalPrice) // Convert to a DoubleStream
                                .sum(); // Calculate the sum of the stream

    @Column(name = "payment_method")
    private String paymentMethod; //Payment method used for the sale (cash, debit card, credit card, etc.). (String)

    @Column(name = "payment_receipt")
    private String paymentReceipt; // Payment Receipt for this sale (String);




    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Sale sale = (Sale) o;
        return getId() != null && Objects.equals(getId(), sale.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
