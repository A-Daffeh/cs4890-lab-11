package com.cs489.Lab7.service;

import com.cs489.Lab7.model.Patient;
import com.cs489.Lab7.model.dto.PatientWithAddressResponse;

import java.util.List;

public interface PatientService {
    List<PatientWithAddressResponse> listAllPatients();

    PatientWithAddressResponse getPatient(Long id);
    PatientWithAddressResponse savePatient(Patient patient);

    PatientWithAddressResponse updatePatient(Long id, Patient patientDetails);

    void deletePatient(Long id);

    List<PatientWithAddressResponse> searchPatients(String searchString);
}
