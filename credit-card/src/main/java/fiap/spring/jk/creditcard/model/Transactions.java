package fiap.spring.jk.creditcard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Transactions {
    
    @Id
    private Long id;

    @Column(name="transaction_number")
    private Long transactionNumber;

    @Column(name="reg_card_number")
    private String  registrationNumberCard;

    @Column(name="transactionValue")
    private Float transactionValue;

    @Column(name="totalAmount")
    private Double totalAmount;

    @Column(name="installments")
    private int installments;

    @Column(name="Date_In")
    private Date    dateTime;
    
    @Column(name="status")
    private String  status;

    @Column(name="active")
    private boolean active;

    
}
