package com.epam.address.AddressApplication.service;

import com.epam.address.AddressApplication.entity.Address;
import com.epam.address.AddressApplication.repository.AddressRepo;
import com.epam.address.AddressApplication.resource.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressById(int employeeId){

        Address address = addressRepo.findAddressByEmplyeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(address,AddressResponse.class);
        return addressResponse;

    }
}
