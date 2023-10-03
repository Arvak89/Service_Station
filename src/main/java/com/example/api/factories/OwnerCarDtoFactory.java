package com.example.api.factories;

import com.example.api.dto.OwnerCarDto;
import com.example.store.model.OwnerCarEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class OwnerCarDtoFactory {

    public OwnerCarDto makeOwnerCarDto(OwnerCarEntity ownerCar) {

        return OwnerCarDto.builder()
                .id(ownerCar.getId())
                .address(ownerCar.getAddress())
                .firstName(ownerCar.getFirstName())
                .middleName(ownerCar.getMiddleName())
                .secondName(ownerCar.getSecondName())
                .build();
    }

    public List<OwnerCarDto> makeOwnersCarDto(List<OwnerCarEntity> ownersCar){

        return ownersCar.stream().map(this::makeOwnerCarDto).collect(Collectors.toList());
    }
}
