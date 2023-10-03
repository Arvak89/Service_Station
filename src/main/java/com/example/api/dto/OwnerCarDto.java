package com.example.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OwnerCarDto {

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

    @NonNull
    @JsonProperty("address")
    String address;
}