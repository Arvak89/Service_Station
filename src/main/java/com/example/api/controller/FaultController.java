package com.example.api.controller;

import com.example.api.dto.CarDto;
import com.example.api.dto.FaultDto;
import com.example.api.factories.FaultDtoFactory;
import com.example.api.service.FaultService;
import com.example.store.model.FaultEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController()
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FaultController {

    FaultService faultService;
    FaultDtoFactory faultDtoFactory;
    public final static String CREATE = "/api/car/{car_id}/employee/{employee_id}/fault";
    public final static String DELETE = "/api/fault/{id}";
    public final static String FETCH_BY_ID = "/api/fault/{fault_id}";
    public final static String FETCH_ALL = "/api/fault/all";
    public final static String FETCH_BY_OWNER_CAR = "/api/owner_car/{owner_car_id}/fault";

    @PostMapping(CREATE)
    public void createFault(
            @PathVariable(name = "car_id", required = true) Long carId,
            @PathVariable(name = "employee_id", required = true) Long employeeId,
            @RequestParam(name = "fault_name",required = true) String  faultName,
            @RequestParam(name = "elimination_time",required = true) Date eliminationTime){

        faultService.createFault(faultName, eliminationTime, employeeId, carId);
    }

    @DeleteMapping(DELETE)
    public void deleteFault(
            @PathVariable(value = "id", required = true) Long id){

        faultService.deleteFault(id);
    }

    @GetMapping(FETCH_BY_ID)
    public FaultDto fetchFault(
            @PathVariable(name = "id", required = true) Long id){

        return faultDtoFactory.makeFaultDto(faultService.fetchFault(id));
    }

    @GetMapping(FETCH_BY_OWNER_CAR)
    public List<FaultDto> fetchFaultByOwnerCar(
            @PathVariable(name = "owner_car_id", required = true) Long id){

        return faultDtoFactory.makeFaultsDto(faultService.fetchFaultsByOwnerId(id));
    }

    @GetMapping(FETCH_ALL)
    public List<FaultDto> fetchAll(){

        return faultDtoFactory.makeFaultsDto(faultService.fetchAll());
    }
}
