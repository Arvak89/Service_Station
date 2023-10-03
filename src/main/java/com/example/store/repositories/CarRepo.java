package com.example.store.repositories;

import com.example.store.model.CarEntity;
import com.example.store.model.OwnerCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<CarEntity, Long> {

    @Query(value =
            "select car.id, car.year_of_release,  car.manufacturer, car.brand, car.number_of_registration, car.owner_car_id " +
                    "from car, fault " +
                    "join employee on fault.employee_id = employee.id " +
                    "where fault.car_id = car.id and employee.id = ?1",
            nativeQuery = true)
    List<CarEntity> findCarsByEmployee(long employeeId);

    CarEntity findByOwnerCar(OwnerCarEntity ownerCar);

    CarEntity findCarEntitiesByNumberOfRegistration(Long numberOfRegistration);
}
