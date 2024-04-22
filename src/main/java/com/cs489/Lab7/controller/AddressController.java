package com.cs489.Lab7.controller;

import com.cs489.Lab7.model.dto.AddressWithPatientResponse;
import com.cs489.Lab7.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public String hello() {
        return "This is the address controller";
    }

    @GetMapping("/list")
    public List<AddressWithPatientResponse> getAllAddressesWithPatients() {
        return addressService.getAllAddressesWithPatientsSortedByCity();
    }
}
