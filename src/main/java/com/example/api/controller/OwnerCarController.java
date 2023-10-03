package com.example.api.controller;

import com.example.api.dto.OwnerCarDto;
import com.example.api.factories.OwnerCarDtoFactory;
import com.example.store.model.OwnerCarEntity;
import com.example.api.service.OwnerCarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OwnerCarController {

    OwnerCarService ownerCarService;
    OwnerCarDtoFactory ownerCarDtoFactory;

    public final static String CREATE = "/api/owner_car";
    public final static String DELETE = "/api/owner_car/{id}";
    public final static String FETCH_BY_NUMBER = "/api/owner_car/{number_of_registration}";
    public final static String FETCH_ALL = "/api/owner_car/all";

    @PostMapping(CREATE)
    public void createOwnerCar(
            @RequestParam(name = "first_name",required = true) String firstName,
            @RequestParam(name = "middle_name",required = true) String secondName,
            @RequestParam(name = "second_name",required = true) String middleName,
            @RequestParam(name = "address",required = true) String address){

        ownerCarService.createOwnerCar(firstName, secondName, middleName, address);
    }

    @GetMapping(FETCH_BY_NUMBER)
    public OwnerCarDto fetchOwnerCarByNumberOfRegistration(
            @PathVariable("number_of_registration") Long numberOfRegistration){

        return ownerCarDtoFactory.makeOwnerCarDto(ownerCarService.fetchOwnerCarByNumberOfRegistration(numberOfRegistration));
    }

    @DeleteMapping(DELETE)
    public void deleteOwnerCar(
            @PathVariable(value = "id", required = true) Long id){

        ownerCarService.deleteOwnerCar(id);
    }

    @GetMapping(FETCH_ALL)
    public List<OwnerCarDto> fetchAll(){

        return ownerCarDtoFactory.makeOwnersCarDto(ownerCarService.fetchAll());
    }
}
