package com.example.service;

import com.example.model.CarEntity;
import com.example.model.EmployeeEntity;
import com.example.model.OwnerCarEntity;
import com.example.repositories.CarRepo;
import com.example.repositories.OwnerCarRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarService {

    OwnerCarRepo ownerCarRepo;
    CarRepo carRepo;

    public CarEntity createCar(Integer yearOfRelease, String manufacturer, Long numberOfRegistration, Long ownerCarId, String brand) {

        OwnerCarEntity ownerCar = ownerCarRepo.findById(ownerCarId)
                .orElseThrow(() ->
                        new RuntimeException(
                                String.format(
                                        "Владелец машины с id: \"%s\" не существует",
                                        ownerCarId
                                )
                        )
                );

        return carRepo.save(CarEntity.builder()
                .manufacturer(manufacturer)
                .numberOfRegistration(numberOfRegistration)
                .yearOfRelease(yearOfRelease)
                .ownerCar(ownerCar)
                .brand(brand)
                .build());
    }

    public void deleteCar(Long carId) {
        carRepo.deleteById(carId);
    }

    public CarEntity fetchCar(Long carId) {
        Optional<CarEntity> carOptional = carRepo.findById(carId);

        CarEntity ownerCar = carOptional.get();

        System.out.println(
                "Машина с такими характеристиками: " +
                        "\nИзготовитель: " + ownerCar.getManufacturer() +
                        "\nМарка: " + ownerCar.getBrand() +
                        "\nНомер регистрации: " + ownerCar.getNumberOfRegistration() +
                        "\nГод выпуска: " + ownerCar.getYearOfRelease());

        return ownerCar;
    }

    public CarEntity findCarByOwnerCar(Long ownerId) {

        OwnerCarEntity ownerCar = ownerCarRepo.findById(ownerId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Владельца с таким id не найдено!"));

        CarEntity car = carRepo.findByOwnerCar(ownerCar);

        System.out.println(
                "Машина с такими характеристиками: " +
                        "\nИзготовитель: " + car.getManufacturer() +
                        "\nМарка: " + car.getBrand() +
                        "\nНомер регистрации: " + car.getNumberOfRegistration() +
                        "\nГод выпуска: " + car.getYearOfRelease());

        return car;
    }

    public CarEntity updateNumberOfRegistrationById(Long carId, Long numberOfRegistration) {

        CarEntity car = carRepo.findById(carId).orElseThrow(() ->
                new RuntimeException(
                        "Владельца с таким id не найдено!"));

        car.setNumberOfRegistration(numberOfRegistration);

        return carRepo.save(car);
    }


    public List<CarEntity> fetchCarsByEmployee(Long employeeId) {

        return carRepo.findCarsByEmployee(employeeId);
    }

}
