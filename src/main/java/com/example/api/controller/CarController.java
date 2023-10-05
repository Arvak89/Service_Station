package com.example.api.controller;

import com.example.api.dto.CarDto;
import com.example.api.factories.CarDtoFactory;
import com.example.store.model.CarEntity;
import com.example.api.service.CarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CarController {

    CarService carService;
    CarDtoFactory carDtoFactory;

    public final static String CREATE = "/api/owner_car/{owner_car_id}/car";
    public final static String DELETE = "/api/car/{id}";
    public final static String FETCH_BY_ID = "/api/car/{id}";
    public final static String FETCH_ALL = "/api/car/all";
    public final static String FETCH_BY_OWNER_CAR = "/api/owner_car/{owner_car_id}/car";
    public final static String FETCH_BY_EMPLOYEE = "/api/employee/{employee_id}/car";

    @PostMapping(CREATE)
    public void createCar(
            @PathVariable(name = "owner_car_id", required = true) Long ownerCarId,
            @RequestParam(name = "year_of_release",required = true) Integer yearOfRelease,
            @RequestParam(name = "manufacturer",required = true) String manufacturer,
            @RequestParam(name = "brand",required = true) String brand,
            @RequestParam(name = "numberOfRegistration",required = true) Long numberOfRegistration){

        carService.createCar(yearOfRelease,manufacturer, numberOfRegistration, ownerCarId, brand);
    }

    @DeleteMapping(DELETE)
    public void deleteCar(
            @PathVariable(value = "id", required = true) Long id){

        carService.deleteCar(id);
    }

    @GetMapping(FETCH_BY_OWNER_CAR)
    public CarDto fetchCarByOwnerCar(
            @PathVariable(name = "owner_car_id", required = true) Long id){

        return carDtoFactory.makeCarDto(carService.fetchCarByOwnerCar(id));
    }

    @GetMapping(FETCH_BY_EMPLOYEE)
    public List<CarDto> fetchCarByEmployee(
            @PathVariable(name = "employee_id", required = true) Long id){

        return carDtoFactory.makeCarsDto(carService.fetchCarsByEmployee(id));
    }

    @GetMapping(FETCH_BY_ID)
    public CarDto fetchCar(
            @PathVariable(name = "id", required = true) Long id){

        return carDtoFactory.makeCarDto(carService.fetchCar(id));
    }

    @GetMapping(FETCH_ALL)
    public List<CarDto> fetchAll(){

        return carDtoFactory.makeCarsDto(carService.fetchAll());
    }
}
