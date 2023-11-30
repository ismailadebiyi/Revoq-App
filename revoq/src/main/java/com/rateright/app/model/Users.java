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
@Entity(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
            @UniqueConstraint(name = "email_unique_constraint", columnNames = "businessEmail")
})
public class Users {

    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )

    @Column(
            name = "userId",
            updatable = false
    )
    private Long userId;
    private String businessName;
    private String businessEmail;
    private String password;
    private String address;
    private String contactPersonName;
    private Integer phoneNo;

    @OneToMany(
            mappedBy = "users",
            cascade = CascadeType.ALL
    )
    private List<Customers> customersList = new ArrayList<>();


}
