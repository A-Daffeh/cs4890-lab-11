package com.cs489.Lab7.model.dto;

public record AddressWithPatientResponse(String street, String city, String state, String postalCode, PatientResponse patientResponse) {
}
