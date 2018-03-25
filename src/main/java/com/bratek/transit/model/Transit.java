package com.bratek.transit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Transits")
@NoArgsConstructor
@Getter
@Setter
@ToString
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
