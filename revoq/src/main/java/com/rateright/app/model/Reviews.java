package com.rateright.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Reviews")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    @Id
    @SequenceGenerator(
            name = "review_id_sequence",
            sequenceName = "review_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_id_sequence"
    )
    @Column(
            name = "reviewId",
            updatable = false
    )
    private Long reviewId;
    private Integer ratings;
    private String comment;
    @ManyToOne
    @JoinColumn(
            name = "transaction_id",
            nullable = false,
            referencedColumnName = "txId",
            foreignKey = @ForeignKey(
                    name = "service_reviews_fk"
            )
    )
    private Transactions transactions;
    @OneToMany(
            mappedBy = "reviews" ,
            cascade = CascadeType.ALL
    )
    private List<IssueLog> logList;

}
