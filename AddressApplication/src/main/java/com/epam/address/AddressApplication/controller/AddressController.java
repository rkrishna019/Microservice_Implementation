package com.epam.address.AddressApplication.controller;

import com.epam.address.AddressApplication.resource.AddressResponse;
import com.epam.address.AddressApplication.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AddressController {

    @Autowired
    private AddressService addressService;
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse>findAddressById(@PathVariable("employeeId") int id){

        AddressResponse addressResponse = addressService.findAddressById(id);
        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }

}
