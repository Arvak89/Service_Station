package com.example.api.service;

import com.example.store.model.CarEntity;
import com.example.store.model.EmployeeEntity;
import com.example.store.model.FaultEntity;
import com.example.store.model.OwnerCarEntity;
import com.example.store.repositories.CarRepo;
import com.example.store.repositories.EmployeeRepo;
import com.example.store.repositories.FaultRepo;
import com.example.store.repositories.OwnerCarRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FaultService {

    FaultRepo faultRepo;
    EmployeeRepo employeeRepo;
    CarRepo carRepo;
    OwnerCarRepo ownerCarRepo;

    public FaultEntity fetchFault(Long faultId) {
        Optional<FaultEntity> faultOptional = faultRepo.findById(faultId);

        return faultOptional.get();
    }

    public FaultEntity createFault(String faultName, Date eliminationTime, Long employeeId, Long carId) {

        EmployeeEntity employee = employeeRepo.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException(
                                String.format(
                                        "Работник с id: \"%s\" не существует",
                                        employeeId
                                )
                        )
                );

        CarEntity car = carRepo.findById(carId)
                .orElseThrow(() ->
                        new RuntimeException(
                                String.format(
                                        "Машины с id: \"%s\" не существует",
                                        carId
                                )
                        )
                );

        return faultRepo.save(FaultEntity.builder()
                .car(car)
                .eliminationTime(eliminationTime)
                .employee(employee)
                .faultName(faultName)
                .build());
    }

    public void deleteFault(Long faultId) {
        faultRepo.deleteById(faultId);
    }

    public List<FaultEntity> fetchFaultsByOwnerId(Long ownerId) {
        long count = 1L;

        OwnerCarEntity ownerCar = ownerCarRepo.findById(ownerId)
                .orElseThrow(() ->
                        new RuntimeException("Такого владельца нет!"));

        CarEntity car = carRepo.findByOwnerCar(ownerCar);

        List<FaultEntity> faults = faultRepo.findByCar(car);

        for (FaultEntity fault : faults) {
            System.out.println(
                    "Неисправность номер " + count + ": " +
                            "\nНеисправность: " + fault.getFaultName() +
                            "\nВремя : " + fault.getEliminationTime());

            count++;
        }

        return faults;
    }

    public List<FaultEntity> fetchAll() {

        return faultRepo.findAll();
    }
}
