package com.cs489.Lab7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;

    @OneToOne(mappedBy = "patientAddress")
    private Patient patient;

    @OneToOne(mappedBy = "surgeryAddress")
    private Surgery surgery;
}
