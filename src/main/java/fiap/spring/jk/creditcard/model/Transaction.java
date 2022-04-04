package fiap.spring.jk.creditcard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Transaction {
    
    @Id
    private Long id;

    @Column(name="transaction_number")
    private Long transactionNumber;

    @Column(name="reg_card_number")
    private String  registrationNumberCard;

    @Column(name="value")
    private Float   value;

    //@Column(name="actualInstallment")
    //private Integer actualInstallment;

    @Column(name="installmentes")
    private int installments;

    @Column(name="Date_In")
    private Date    dateTime;
    
    @Column(name="status")
    private String  status;

    @Column(name="active")
    private boolean active;

    
}
