package com.rateright.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "Transactions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @Id
    @SequenceGenerator(
            name = "tx_id_sequence",
            sequenceName = "tx_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tx_id_sequence"
    )
    @Column(
            name = "txId",
            updatable = false
    )
    private Long txId;
    private String txDetails;
    private String reviewLink;
    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "customerId",
            foreignKey = @ForeignKey(
                    name = "customer_transaction_fk"
            )
    )
    private Customers customers;
    @OneToMany(
            mappedBy = "transactions",
            cascade = CascadeType.ALL
    )
    private List<Reviews> reviews = new ArrayList<>();
}
