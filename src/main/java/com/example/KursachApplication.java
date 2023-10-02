package com.example;

import com.example.model.CarEntity;
import com.example.model.EmployeeEntity;
import com.example.model.OwnerCarEntity;
import com.example.service.CarService;
import com.example.service.EmployeeService;
import com.example.service.FaultService;
import com.example.service.OwnerCarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KursachApplication implements CommandLineRunner {

    EmployeeService employeeService;
    CarService carService;
    OwnerCarService ownerCarService;
    FaultService faultService;


    public static void main(String[] args) {
        SpringApplication.run(KursachApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        EmployeeEntity employee = employeeService.createEmployee("sadas", "dasdas", "asdas");
        OwnerCarEntity ownerCar = ownerCarService.createOwnerCar("sdasda", "sadasd", "dasdas", "sdasdas");
        CarEntity car = carService.createCar(2050, "asdasda", 1111111L, ownerCar.getId(), "asdasdas");
        faultService.createFault("asdas", Date.valueOf(LocalDate.now()), employee.getId(), car.getId());

        System.out.println(carService.updateNumberOfRegistrationById(1L, 22222222L));
    }
}
