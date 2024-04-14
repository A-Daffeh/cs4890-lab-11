package com.cs489.Lab7.model.dto;

import java.time.LocalDate;

public record PatientWithAddressResponse(String patientId, String firstName, String lastName, String phone, String email,
                                         LocalDate dateOfBirth, AddressResponse address) {
}
