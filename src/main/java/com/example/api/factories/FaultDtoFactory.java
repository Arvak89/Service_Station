package com.example.api.factories;

import com.example.api.dto.CarDto;
import com.example.api.dto.FaultDto;
import com.example.store.model.CarEntity;
import com.example.store.model.FaultEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FaultDtoFactory {

    public FaultDto makeFaultDto(FaultEntity fault) {

        return FaultDto.builder()
                .id(fault.getId())
                .faultName(fault.getFaultName())
                .eliminationTime(fault.getEliminationTime())
                .build();
    }

    public List<FaultDto> makeFaultsDto(List<FaultEntity> faults){

        return faults.stream().map(this::makeFaultDto).collect(Collectors.toList());
    }
}
