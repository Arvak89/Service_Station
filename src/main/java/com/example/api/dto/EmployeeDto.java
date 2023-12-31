package com.example.api.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    @NonNull
    Long id;

    @NonNull
    @JsonProperty("first_name")
    String firstName;

    @NonNull
    @JsonProperty("second_name")
    String secondName;

    @NonNull
    @JsonProperty("middle_name")
    String middleName;

    @JsonProperty("elimination_time")
    Date eliminationTime;
}
