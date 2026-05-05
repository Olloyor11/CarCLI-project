package com.ollayor.main.java.car;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class CarService {
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getAllCar() {
        return carDAO.getCars();
    }

    public List<Car> getAvailableCars(){
        List<Car> available = getAllCar()
                .stream()
                .filter(car -> !car.isBooked() )
                .collect(Collectors.toCollection(ArrayList::new));
        if (available.isEmpty()){
            throw new IllegalStateException("There is not any car");
        }
        return available;
    }

    public List<Car> getElectricCars(){
        List<Car> electric = getAllCar()
                .stream()
                .filter(car -> car.isElectric() && !car.isBooked())
                .collect(Collectors.toCollection(ArrayList::new));
        if (electric.isEmpty()){
            throw new IllegalStateException("For now there is not any electric cars available");
        }
        return electric;
    }

    public Car getCarByRegNumber(String registrationNum){
        Car carByReg = getAllCar()
                .stream()
                .filter(car -> car.getRegNumber()
                        .equalsIgnoreCase(registrationNum))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Car not found!"));
        return carByReg;
    }

    public Car getCarById(UUID id){
        Car carById = getAllCar()
                .stream()
                .filter(car -> car
                        .getCarId()
                        .equals(id))
                .findFirst().orElseThrow(() ->
                        new IllegalStateException("Not found"));
        return carById;
    }


}
