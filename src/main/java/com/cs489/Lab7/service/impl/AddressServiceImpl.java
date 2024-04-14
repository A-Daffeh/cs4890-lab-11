package com.cs489.Lab7.service.impl;

import com.cs489.Lab7.converter.AddressMapper;
import com.cs489.Lab7.model.dto.AddressWithPatientResponse;
import com.cs489.Lab7.service.AddressService;
import com.cs489.Lab7.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public List<AddressWithPatientResponse> getAllAddressesWithPatientsSortedByCity() {
        var addresses = addressRepository.findAllWithPatientsOrderByCity();
        return addresses.stream()
                .map(address -> AddressMapper.convertToAddressWithPatient(address))
                .collect(Collectors.toList());
    }
}
