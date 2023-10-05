package com.example.api.service;

import com.example.store.model.CarEntity;
import com.example.store.model.OwnerCarEntity;
import com.example.store.repositories.CarRepo;
import com.example.store.repositories.OwnerCarRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OwnerCarService {

    OwnerCarRepo ownerCarRepo;
    CarRepo carRepo;

    public OwnerCarEntity createOwnerCar(String firstName, String secondName, String middleName, String address) {

        return ownerCarRepo.save(OwnerCarEntity.builder()
                .firstName(firstName)
                .secondName(secondName)
                .middleName(middleName)
                .address(address)
                .build());
    }

    public void deleteOwnerCar(Long ownerCarId) {
        ownerCarRepo.deleteById(ownerCarId);
    }

    public OwnerCarEntity fetchOwnerCarByNumberOfRegistration(Long numberOfRegistration) {

        CarEntity car = carRepo.findCarEntitiesByNumberOfRegistration(numberOfRegistration);

        return ownerCarRepo.findByCar(car);
    }

//    public OwnerCarEntity fetchOwnerCar(Long ownerCarId){
//        Optional<OwnerCarEntity> ownerCarOptional = ownerCarRepo.findById(ownerCarId);
//
//        OwnerCarEntity ownerCar = ownerCarOptional.get();
//
//        System.out.println(
//                "Владелец машины: " +
//                "\nИмя: " + ownerCar.getFirstName() +
//                "\nФамилия: " + ownerCar.getSecondName() +
//                "\nОтчество: " + ownerCar.getMiddleName() +
//                "\nАдрес: " + ownerCar.getAddress());
//
//        return ownerCar;
//    }

    public List<OwnerCarEntity> fetchOwnersCarByFault(String faultName) {

        List<OwnerCarEntity> ownerCarEntities = ownerCarRepo.ownersCarByFault(faultName);

        for (OwnerCarEntity ownerCar : ownerCarEntities) {
            System.out.println(
                    "Владелец машины: " +
                            "\nИмя: " + ownerCar.getFirstName() +
                            "\nФамилия: " + ownerCar.getSecondName() +
                            "\nОтчество: " + ownerCar.getMiddleName());
        }
        return ownerCarEntities;
    }

    public List<OwnerCarEntity> fetchAll(){

        return ownerCarRepo.findAll();
    }
}
