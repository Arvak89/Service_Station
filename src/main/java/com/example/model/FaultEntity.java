package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "fault", schema = "car_info", catalog = "")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FaultEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "fault_name", nullable = false, length = 45)
    String faultName;

    @Column(name = "elimination_time", nullable = false)
    Date eliminationTime;

    @OneToOne
    EmployeeEntity employee;

    @ManyToOne(cascade = CascadeType.REFRESH)
    CarEntity car;

}
