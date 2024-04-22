package com.cs489.Lab7.service.impl;

import com.cs489.Lab7.converter.PatientMapper;
import com.cs489.Lab7.exception.PatientNotException;
import com.cs489.Lab7.model.Address;
import com.cs489.Lab7.model.Patient;
import com.cs489.Lab7.model.dto.PatientWithAddressResponse;
import com.cs489.Lab7.repository.AddressRepository;
import com.cs489.Lab7.repository.PatientRepository;
import com.cs489.Lab7.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<PatientWithAddressResponse> listAllPatients() {
        List<Patient> patients = patientRepository.findAllByOrderByLastNameAsc();

        return patients.stream()
                .map(PatientMapper::convertToPatientWithAddress)
                .collect(Collectors.toList());
    }

    @Override
    public PatientWithAddressResponse getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotException("Patient not found"));
        return PatientMapper.convertToPatientWithAddress(patient);
    }

    @Override
    public PatientWithAddressResponse savePatient(Patient patient) {
        Address patientAddress = patient.getPatientAddress();
        if (patientAddress.getId() == null) {
            addressRepository.save(patientAddress);
            patient.setPatientAddress(patientAddress);
        }
        return PatientMapper.convertToPatientWithAddress(patientRepository.save(patient));
    }

    @Override
    public PatientWithAddressResponse updatePatient(Long id, Patient patientDetails) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotException("Patient not found"));
        patient.setPatientId(patientDetails.getPatientId());
        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setPhone(patientDetails.getPhone());
        patient.setEmail(patientDetails.getEmail());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());

        Address existingAddress = patient.getPatientAddress();
        Address newAddress = patientDetails.getPatientAddress();
        if (existingAddress != null && newAddress != null) {
            existingAddress.setStreet(newAddress.getStreet());
            existingAddress.setCity(newAddress.getCity());
            existingAddress.setState(newAddress.getState());
            existingAddress.setPostalCode(newAddress.getPostalCode());
        }
        return PatientMapper.convertToPatientWithAddress(patientRepository.save(patient));
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotException("Patient not found"));
        patientRepository.delete(patient);
    }

    @Override
    public List<PatientWithAddressResponse> searchPatients(String query) {
        List<Patient> patients =  patientRepository.searchByKeyword(query);
        return patients.stream()
                .map(patient -> PatientMapper.convertToPatientWithAddress(patient))
                .collect(Collectors.toList());
    }
}
