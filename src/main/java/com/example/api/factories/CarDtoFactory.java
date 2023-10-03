package com.example.api.factories;

import com.example.api.dto.CarDto;
import com.example.api.dto.OwnerCarDto;
import com.example.store.model.CarEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDtoFactory {

    public CarDto makeCarDto(CarEntity car) {

        return CarDto.builder()
                .id(car.getId())
                .numberOfRegistration(car.getNumberOfRegistration())
                .yearOfRelease(car.getYearOfRelease())
                .manufacturer(car.getManufacturer())
                .brand(car.getBrand())
                .build();
    }

    public List<CarDto> makeCarsDto(List<CarEntity> cars){

        return cars.stream().map(this::makeCarDto).collect(Collectors.toList());
    }
}
