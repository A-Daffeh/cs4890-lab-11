package com.cs489.Lab7.converter;

import com.cs489.Lab7.model.Address;
import com.cs489.Lab7.model.dto.AddressResponse;
import com.cs489.Lab7.model.dto.AddressWithPatientResponse;

public class AddressMapper {
    public static AddressResponse convertToAddressResponse(Address address) {
        return new AddressResponse(
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode()
        );
    }

    public static AddressWithPatientResponse convertToAddressWithPatient(Address address) {
        return new AddressWithPatientResponse(
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode(),
                PatientMapper.convertToPatientResponse(address.getPatient())
        );
    }
}
