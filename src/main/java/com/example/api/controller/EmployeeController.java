package com.example.api.controller;

import com.example.api.dto.EmployeeDto;
import com.example.api.factories.EmployeeDtoFactory;
import com.example.store.model.EmployeeEntity;
import com.example.api.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeController {

    EmployeeService employeeService;
    EmployeeDtoFactory employeeDtoFactory;
    public final static String CREATE = "/api/employee";
    public final static String DELETE = "/api/employee/{id}";
    public final static String FETCH_BY_ID = "/api/employee/{id}";
    public final static String FETCH_ALL = "/api/employee/all";

    @PostMapping(CREATE)
    public void createEmployee(
            @RequestParam(name = "first_name", required = true) String firstName,
            @RequestParam(name = "second_name", required = true) String secondName,
            @RequestParam(name = "middle_name", required = true) String middleName){

        employeeService.createEmployee(firstName, secondName, middleName);
    }

    @GetMapping(FETCH_ALL)
    public List<EmployeeDto> createEmployee(){

        return employeeDtoFactory.makeEmployeesDto(employeeService.fetchAllEmployee());
    }

    @GetMapping(FETCH_BY_ID)
    public EmployeeDto createEmployee(
            @PathVariable(name = "id", required = true) Long id){

        return employeeDtoFactory.makeEmployeeDto(employeeService.fetchEmployee(id));
    }

    @DeleteMapping(DELETE)
    public void deleteEmployee(
            @PathVariable(name = "id", required = true) Long id){

        employeeService.deleteEmployee(id);
    }
}
