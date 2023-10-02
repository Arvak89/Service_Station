package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "car", schema = "car_info", catalog = "")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "year_of_release", nullable = false)
    Integer yearOfRelease;

    @Column(name = "manufacturer", nullable = false, length = 45)
    String manufacturer;

    @Column(name = "brand", nullable = false, length = 45)
    String brand;

    @Column(name = "number_of_registration", nullable = false)
    Long numberOfRegistration;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    List<FaultEntity> faults;

    @OneToOne(cascade = CascadeType.REFRESH)
    OwnerCarEntity ownerCar;
}
