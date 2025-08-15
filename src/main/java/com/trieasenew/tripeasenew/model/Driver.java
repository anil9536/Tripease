package com.trieasenew.tripeasenew.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Driver Table")
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverID")
    List<Booking> booking = new ArrayList<>();

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "cabId")
    Cab cab;
}
