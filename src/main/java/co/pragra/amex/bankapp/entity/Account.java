package co.pragra.amex.bankapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    private Long id;

    @Column(name = "ACCOUNT_NUMBER", nullable = false, unique = true)
    private int accountNo;

    private AccountType accountType;

    private double balance;

    private double accountFee;

    @OneToMany(mappedBy = "account")
    List<Transaction> transactions;

}
