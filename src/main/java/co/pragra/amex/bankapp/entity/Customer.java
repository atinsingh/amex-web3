package co.pragra.amex.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "UUID")
    private UUID uuid;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private Date createDate = new Date();
    private Date updateDate = new Date();
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Account> accounts;


}
