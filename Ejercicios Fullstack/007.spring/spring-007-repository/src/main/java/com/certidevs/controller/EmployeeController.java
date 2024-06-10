package com.certidevs.controller;

import com.certidevs.model.Employee;
import com.certidevs.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeRepository repo;

    /*
    Cómo realizar filtros sobre empleados en un controlador REST

    OK http://localhost:8080/employees --> repo.findAll()

    OK http://localhost:8080/employees?companyCity=Madrid --> repo.findByCompany_City("Madrid")

    OK http://localhost:8080/employees?postalCode=28002 --> findByCompany_PostalCode("28002")

    OK http://localhost:8080/employees?companyCity=Madrid&postalCode=28001 --> findByCompany_CityAndCompany_PostalCode("Madrid", "28001")
     */
    @GetMapping("employees")
    public List<Employee> findAll(
            @RequestParam(required = false) String companyCity,
            @RequestParam(required = false) String postalCode
    ) {
        if(StringUtils.hasLength(companyCity) && StringUtils.hasLength(postalCode))
            return repo.findByCompany_CityAndCompany_PostalCode(companyCity, postalCode);

        else if (StringUtils.hasLength(companyCity))
            return repo.findByCompany_City(companyCity);

        else if (StringUtils.hasLength(postalCode))
            return repo.findByCompany_PostalCode(postalCode);

        else
            return repo.findAll();
    }




























}
