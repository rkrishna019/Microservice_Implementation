package com.epam.spring.Employee.controller;

import com.epam.spring.Employee.Response.EmployeeResponse;
import com.epam.spring.Employee.Service.EmployeeService;
import com.epam.spring.Employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){
        EmployeeResponse employeeResponse = employeeService.getEmployeeByID(id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }


}
