package com.example.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @Column(name = "middle_name", nullable = false, length = 45)
    String middleName;
}
