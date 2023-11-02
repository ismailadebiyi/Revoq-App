package com.rateright.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Resolution")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resolutions {

    @Id
    @SequenceGenerator(
            name = "resolve_id_generator",
            sequenceName = "resolve_id_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "resolve_id_generator"
    )
    private Long resolveId;
    private Long ticketId;
    private String resolutionComments;
    private LocalDateTime updateTime;
}
