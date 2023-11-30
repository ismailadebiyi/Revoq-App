package com.rateright.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@Entity(name = "Customers")
@AllArgsConstructor
@NoArgsConstructor

public class Customers {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    @Column(
            name = "customerId",
            updatable = false
    )
    private Long customerId;
    private String companyName;
    private String email;
    private Integer phoneNumber;
    private byte avatar;
    @OneToMany(
            mappedBy = "customers",
            cascade = CascadeType.ALL
    )
    private List<Transactions> transactionsList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "userId",
            foreignKey = @ForeignKey(
                    name = "user_id_fk"
            )
    )
    private Users users;

    public void addTransaction(Transactions transactions){
        if(!this.transactionsList.contains(transactions)){
            this.transactionsList.add(transactions);
            transactions.setCustomers(this);
        }
    }

    public void removeTransaction(Transactions transactions){
        if(this.transactionsList.contains(transactions)){
            this.transactionsList.remove(transactions);
            transactions.setCustomers(null);
        }
    }

}
