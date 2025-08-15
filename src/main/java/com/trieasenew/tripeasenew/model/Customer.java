package com.trieasenew.tripeasenew.model;

import com.trieasenew.tripeasenew.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer Table")
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String email;
    @Enumerated(value  = EnumType.STRING)
    private Gender gender;

        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "customerID")
        List<Booking>  list= new ArrayList<>();
}
