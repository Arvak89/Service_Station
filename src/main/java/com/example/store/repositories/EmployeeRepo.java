package com.example.store.repositories;

import com.example.store.model.EmployeeEntity;
import com.example.store.model.FaultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

    @Query(value =
            "select employee.id, employee.first_name,  employee.second_name, employee.middle_name " +
            "from employee, fault " +
            "join car on car.id = fault.car_id " +
            "where fault.employee_id = employee.id and car.id = ?1",
    nativeQuery = true)
    List<EmployeeEntity> fetchEmployeeCar(long carId);

    EmployeeEntity findEmployeeEntitiesByFault(FaultEntity fault);
}
