package com.epam.spring.Employee.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

    private int id;

    private String lane1;

    private String lane2;

    private String state;

    private int zip;
}
