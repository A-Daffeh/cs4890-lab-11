package com.cs489.Lab7.converter;

import com.cs489.Lab7.model.Patient;
import com.cs489.Lab7.model.dto.PatientResponse;
import com.cs489.Lab7.model.dto.PatientWithAddressResponse;

public class PatientMapper {

    public static PatientResponse convertToPatientResponse(Patient patient) {
        return new PatientResponse(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPhone(),
                patient.getEmail(),
                patient.getDateOfBirth()
        );
    }
    public static PatientWithAddressResponse convertToPatientWithAddress(Patient patient) {
        return new PatientWithAddressResponse(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPhone(),
                patient.getEmail(),
                patient.getDateOfBirth(),
                AddressMapper.convertToAddressResponse(patient.getPatientAddress())
        );
    }
}
