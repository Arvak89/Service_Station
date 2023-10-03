package com.example.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FaultDto {

    @NonNull
    Long id;

    @NonNull
    @JsonProperty("fault_name")
    String faultName;

    @NonNull
    @JsonProperty("elimination_time")
    Date eliminationTime;

}
