package com.example.store.repositories;

import com.example.store.model.CarEntity;
import com.example.store.model.OwnerCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerCarRepo extends JpaRepository<OwnerCarEntity, Long> {

    @Query(value =
            "select owner_car.id, owner_car.first_name, owner_car.second_name, owner_car.middle_name, owner_car.address " +
                    "from owner_car, fault " +
                    "join car on fault.car_id = car.id " +
                    "where fault.fault_name = ?1",
            nativeQuery = true)
    List<OwnerCarEntity> ownersCarByFault(String faultName);

    OwnerCarEntity findByCar(CarEntity car);
}