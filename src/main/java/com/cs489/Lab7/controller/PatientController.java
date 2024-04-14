package com.cs489.Lab7.controller;

import com.cs489.Lab7.model.Patient;
import com.cs489.Lab7.model.dto.PatientWithAddressResponse;
import com.cs489.Lab7.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/list")
    public ResponseEntity<List<PatientWithAddressResponse>> getAllPatients() {
        return ResponseEntity.ok(patientService.listAllPatients());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PatientWithAddressResponse> getPatient(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatus.FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<PatientWithAddressResponse> createPatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientWithAddressResponse> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return new ResponseEntity<>(patientService.updatePatient(id, patientDetails), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PatientWithAddressResponse>> searchPatients(@RequestParam String query) {
        return ResponseEntity.ok(patientService.searchPatients(query));
    }
}
