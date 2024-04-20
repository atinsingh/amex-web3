package co.pragra.amex.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false)
    @JsonIgnore
    private Account account;

    private Date tranactionDate;

    private double amount;

    private String description;
}
