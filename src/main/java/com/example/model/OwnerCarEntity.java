package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "owner_car", schema = "car_info", catalog = "")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OwnerCarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "second_name", nullable = false, length = 45)
    private String secondName;

    @Column(name = "middle_name", nullable = false, length = 45)
    private String middleName;

    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @OneToOne(mappedBy = "ownerCar", cascade = CascadeType.ALL)
    CarEntity car;
}
