package com.example.api.factories;

import com.example.api.dto.FaultDto;
import com.example.store.model.FaultEntity;
import org.springframework.stereotype.Component;

@Component
public class FaultDtoFactory {

    public FaultDto makeFaultDto(FaultEntity fault) {

        return FaultDto.builder()
                .id(fault.getId())
                .faultName(fault.getFaultName())
                .eliminationTime(fault.getEliminationTime())
                .build();
    }
}
