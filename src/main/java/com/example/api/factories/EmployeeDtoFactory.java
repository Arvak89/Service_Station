package com.example.api.factories;

import com.example.api.dto.EmployeeDto;
import com.example.store.model.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDtoFactory {

    public EmployeeDto makeEmployeeDto(EmployeeEntity employee) {

        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .middleName(employee.getMiddleName())
                .secondName(employee.getSecondName())
                .build();
    }

    public List<EmployeeDto> makeEmployeesDto(List<EmployeeEntity> employees){

        return employees.stream().map(this::makeEmployeeDto).collect(Collectors.toList());
    }
}
