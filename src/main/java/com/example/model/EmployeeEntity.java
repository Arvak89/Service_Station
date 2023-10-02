package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "employee", schema = "car_info", catalog = "")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "first_name", nullable = false, length = 45)
    String firstName;

    @Column(name = "second_name", nullable = false, length = 45)
    String secondName;

    @Column(name = "middle_name", nullable = false, length = 45)
    String middleName;

    @OneToOne(mappedBy = "employee")
    FaultEntity fault;
}
