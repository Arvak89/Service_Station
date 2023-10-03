package com.example.api.service;

import com.example.store.model.EmployeeEntity;
import com.example.store.model.FaultEntity;
import com.example.store.repositories.CarRepo;
import com.example.store.repositories.EmployeeRepo;
import com.example.store.repositories.FaultRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService {

    EmployeeRepo employeeRepo;
    CarRepo carRepo;
    FaultRepo faultRepo;

    public EmployeeEntity createEmployee(String firstName, String secondName, String middleName) {

        return employeeRepo.save(EmployeeEntity.builder()
                .firstName(firstName)
                .secondName(secondName)
                .middleName(middleName)
                .build());
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    public EmployeeEntity fetchEmployee(Long employeeId) {

        Optional<EmployeeEntity> employeeOptional = employeeRepo.findById(employeeId);

        EmployeeEntity employee = new EmployeeEntity();

        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        }

        System.out.println(
                "Работник: " +
                        "\nИмя: " + employee.getFirstName() +
                        "\nФамилия: " + employee.getSecondName() +
                        "\nОтчество: " + employee.getMiddleName());

        return employee;
    }

    public List<EmployeeEntity> fetchAllEmployee(){

        return employeeRepo.findAll();
    }

    public EmployeeEntity findEmployeeByFault(Long faultId){

        FaultEntity fault = faultRepo.findById(faultId).orElseThrow(() ->
                new RuntimeException(
                        String.format(
                                "Неисправности с id: \"%s\" не существует",
                                faultId
                        )
                )
        );

        EmployeeEntity employee = employeeRepo.findEmployeeEntitiesByFault(fault);

        System.out.println(
                "Работник: " +
                        "\nИмя: " + employee.getFirstName() +
                        "\nФамилия: " + employee.getSecondName() +
                        "\nОтчество: " + employee.getMiddleName());

        return employee;
    }

    public List<EmployeeEntity> fetchEmployeeCar(Long carId) {
        return employeeRepo.fetchEmployeeCar(carId);
    }
}
