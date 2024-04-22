package com.cs489.Lab7.service;

import com.cs489.Lab7.exception.PatientNotException;
import com.cs489.Lab7.model.Address;
import com.cs489.Lab7.model.Patient;
import com.cs489.Lab7.model.dto.PatientWithAddressResponse;
import com.cs489.Lab7.repository.PatientRepository;
import com.cs489.Lab7.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceIntegrationTest {
    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Test
    public void testFindExistingPatientById() {
        long validId = 1L;
        Patient patient = createSamplePatient(validId);
        when(patientRepository.findById(validId)).thenReturn(Optional.of(patient));

        PatientWithAddressResponse result = patientService.getPatient(validId);

        assertNotNull(result);
        assertEquals(patient.getPatientId(), result.patientId());
        assertEquals(patient.getFirstName(), result.firstName());
        assertEquals(patient.getLastName(), result.lastName());
        assertEquals(patient.getPhone(), result.phone());
        assertEquals(patient.getEmail(), result.email());
        assertEquals(patient.getDateOfBirth(), result.dateOfBirth());
        assertEquals(patient.getPatientAddress().getStreet(), result.address().street());
        assertEquals(patient.getPatientAddress().getCity(), result.address().city());
        assertEquals(patient.getPatientAddress().getState(), result.address().state());
        assertEquals(patient.getPatientAddress().getPostalCode(), result.address().postalCode());
    }

    @Test
    public void testFindNonExistingPatientById() {
        long nonExistingId = Long.MAX_VALUE;
        when(patientRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        assertThrows(PatientNotException.class, () -> {
            patientService.getPatient(nonExistingId);
        });
    }

    private Patient createSamplePatient(long id) {
        Address address = Address.builder()
                .id(1L)
                .street("123 Main St")
                .city("Anytown")
                .state("State")
                .postalCode("12345")
                .build();

        return Patient.builder()
                .id(id)
                .patientId("P001")
                .firstName("John")
                .lastName("Doe")
                .phone("1234567890")
                .email("john.doe@example.com")
                .dateOfBirth(LocalDate.of(1990, 5, 15))
                .patientAddress(address)
                .build();
    }
}
