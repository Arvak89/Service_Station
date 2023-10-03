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
public class CarDto {

    @NonNull
    Long id;

    @NonNull
    @JsonProperty("year_of_release")
    Integer yearOfRelease;

    @NonNull
    String manufacturer;

    @NonNull
    String brand;

    @NonNull
    @JsonProperty("number_of_registration")
    Long numberOfRegistration;
}
