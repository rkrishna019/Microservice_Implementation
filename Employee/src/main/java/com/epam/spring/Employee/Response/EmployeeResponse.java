package com.epam.spring.Employee.Response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeResponse {

    private int id;

    private String name;

    private String blodd_group;

    private String email;

    private AddressResponse addressResponse;
}
