package com.bratek.transit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Transits")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Transit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String sourceAddress;
    private String destinationAddress;
    private Float price;
    private LocalDate date;



}
