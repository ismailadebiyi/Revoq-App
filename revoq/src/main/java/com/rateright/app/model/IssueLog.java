package com.rateright.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity(name = "IssueLog")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueLog {

    @Id
    @SequenceGenerator(
            name = "ticket_id_generator",
            sequenceName = "ticket_id_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_id_generator"
    )
    @Column(
            name = "ticketId",
            updatable = false
    )
    private Long ticketId;
    private String issueDescription;
    private Status status;
    private LocalDateTime ticketTime;
    @ManyToOne
    @JoinColumn(
            name = "review_id",
            nullable = false,
            referencedColumnName = "reviewId",
            foreignKey = @ForeignKey(
                    name = "review_issue_fk"
            )
    )
    private Reviews reviews;

}
