package com.cs489.Lab7.service;

import com.cs489.Lab7.model.dto.AddressWithPatientResponse;

import java.util.List;

public interface AddressService {
    List<AddressWithPatientResponse> getAllAddressesWithPatientsSortedByCity();
}
