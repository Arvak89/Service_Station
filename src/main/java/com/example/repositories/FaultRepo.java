package com.example.repositories;

import com.example.model.CarEntity;
import com.example.model.EmployeeEntity;
import com.example.model.FaultEntity;
import com.example.model.OwnerCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaultRepo extends JpaRepository<FaultEntity, Long> {

    List<FaultEntity> findByCar(CarEntity car);
}
