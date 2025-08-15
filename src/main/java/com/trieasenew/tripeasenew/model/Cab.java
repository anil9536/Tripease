package com.trieasenew.tripeasenew.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Cab Table")
@Builder
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;
    private String cabNumber;
    private String cabModel;
    private double perKmRate;
    private boolean cabAvailability;

}
