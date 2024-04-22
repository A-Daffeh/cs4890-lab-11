package com.cs489.Lab7.controller;

import com.cs489.Lab7.model.dto.AddressResponse;
import com.cs489.Lab7.model.dto.PatientWithAddressResponse;
import com.cs489.Lab7.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PatientControllerUnitTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @Test
    public void testGetAllPatients() {
        List<PatientWithAddressResponse> patients = createSamplePatients();
        when(patientService.listAllPatients()).thenReturn(patients);

        ResponseEntity<List<PatientWithAddressResponse>> responseEntity = patientController.getAllPatients();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(patients, responseEntity.getBody());
        verify(patientService, times(1)).listAllPatients();
    }

    private List<PatientWithAddressResponse> createSamplePatients() {
        List<PatientWithAddressResponse> patients = new ArrayList<>();

        PatientWithAddressResponse patient1 = new PatientWithAddressResponse(
                "P001",
                "John",
                "Doe",
                "1234567890",
                "john.doe@example.com",
                LocalDate.of(1990, 5, 15),
                new AddressResponse("123 Main St", "Anytown", "State", "12345")
        );
        patients.add(patient1);

        PatientWithAddressResponse patient2 = new PatientWithAddressResponse(
                "P002",
                "Jane",
                "Smith",
                "0987654321",
                "jane.smith@example.com",
                LocalDate.of(1985, 10, 20),
                new AddressResponse("456 Oak St", "Othertown", "State", "54321")
        );
        patients.add(patient2);

        return patients;
    }
}
