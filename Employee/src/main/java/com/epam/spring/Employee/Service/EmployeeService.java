package com.epam.spring.Employee.Service;

import com.epam.spring.Employee.Response.AddressResponse;
import com.epam.spring.Employee.Response.EmployeeResponse;
import com.epam.spring.Employee.entity.Employee;
import com.epam.spring.Employee.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
   private EmployeeRepo employeeRepo;
    @Autowired
    private WebClient webClient;

    public EmployeeResponse getEmployeeByID(int id){

        //Making an api call to get the address details.
   AddressResponse addressResponse = webClient
           .get()
           .uri("/address/"+id)
           .retrieve()
           .bodyToMono(AddressResponse.class)
           .block();
        Employee employee = employeeRepo.findById(id)
                .orElse(new Employee());// Returns a new Employee object if not found
        EmployeeResponse employeeResponse = modelMapper.map(employee,EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;

    }

}
