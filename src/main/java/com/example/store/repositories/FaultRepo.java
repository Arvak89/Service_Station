package com.example.store.repositories;

import com.example.store.model.CarEntity;
import com.example.store.model.FaultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaultRepo extends JpaRepository<FaultEntity, Long> {

    List<FaultEntity> findByCar(CarEntity car);
}
