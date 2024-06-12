package com.example.odontopharmacenterdias.entities;


import com.example.odontopharmacenterdias.entities.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // Unique identifier for the payment (Long)

    @OneToOne
    private Costumer costumer; // Reference to the customer associated with the payment (Long)

    @ManyToOne
    private TreatmentPlan treatmentPlan; // Reference to the treatment plan related to the payment (Long)

    @ManyToMany
    private List<Procedure> procedureList; // List of procedures included in the payment (List<Procedure>)

    private Double total = total(); // Total amount of the payment (Double)

    @Column(name = "payment_method") @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; // Payment method used for the service (cash, debit card, credit card, etc.). (Enum/String)

    private Date paymentDate; // Date the payment was made (Date)

    private String paymentReceipt = generatePaymentReceipts(); // Auto generating payment receipts based on payment methods;

    public Double total(){
        Double total = 0.0;
        for (Procedure procedure : procedureList){
            total += procedure.getCost();
        }
        return total;
    }

    public String generatePaymentReceipts(){
        if (paymentMethod.equals("PIX")){
            // Generate receipt content specific to PIX Payment
            return "Name: " + costumer.getName() + "\n"
                    + "Value: R$ " + total() + "\n"
                    + " PIX RECEBIDO COM SUCESSO!";
        } else if (paymentMethod.equals("CREDITCARD")) {
            // Generate receipt content specific to Credit Card Payment
            return "Name: " + costumer.getName() + "\n"
                    + "Value: R$ " + total() + "\n"
                    + "CREDIT CARD RECEBIDO COM SUCESSO!";
        } else if (paymentMethod.equals("DEBITCARD")) {
            // Generate receipt content specific to Debit Card Payment
            return "Name: " + costumer.getName() + "\n"
                    + "Value: R$ " + total() + "\n"
                    + "DEBIT CARD RECEBIDO COM SUCESSO!";
        } else if (paymentMethod.equals("CASH")) {
            // Generate receipt content specific to Cash Payment
            return "Name: " + costumer.getName() + "\n"
                    + "Value: R$ " + total() + "\n"
                    + "CASH RECEBIDO COM SUCESSO!";
        } else if (paymentMethod.equals("PLANO")) {
            // Generate receipt content specific to Credit Card Payment
            return "Name: " + costumer.getName() + "\n"
                    + "Value: R$ " + total() + "\n"
                    + "PLANO DE SAUDE RECEBIDO COM SUCESSO!";
        } else {
            // Generate receipt content specific to Credit Card Payment
            return "Name: " + costumer.getName() + "\n"
                    + "Value: R$ " + total() + "\n"
                    + "SUS PHARMACIA POPULAR RECEBIDO COM SUCESSO!";
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Payment payment = (Payment) o;
        return getId() != null && Objects.equals(getId(), payment.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
