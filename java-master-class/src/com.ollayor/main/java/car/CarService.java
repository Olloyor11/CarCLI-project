package com.ollayor.main.java.car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarService {
    private final CarArrayDataAccessService carArrayDataAccessService;

    public CarService(CarArrayDataAccessService carArrayDataAccessService) {
        this.carArrayDataAccessService = carArrayDataAccessService;
    }

    public ArrayList<Car> getAllCar() {
        return carArrayDataAccessService.getCars();
    }

    public ArrayList<Car> getAvailableCars(){
        ArrayList<Car> available = new ArrayList<>();
        for (Car car :getAllCar()){
            if (!car.isBooked()){
              available.add(car);
            }
        }
        if (available.isEmpty()){
            throw new IllegalStateException("There is not any car");
        }

        return available;
    }
    public ArrayList<Car> getElectricCars(){
        ArrayList<Car> electric = new ArrayList<>();
        for (Car car :getAllCar()){
            if (!car.isBooked() && car.isElectric()){
                electric.add(car);
            }
        }
        if (electric.isEmpty()){
            throw new IllegalStateException("For now there is not any electric cars available");
        }
        return electric;
    }

    public Car getCarByRegNumber(String registrationNum){
        for (Car car : getAllCar()){
            if (car.getRegNumber().equalsIgnoreCase(registrationNum)){
                return car;
            }
        }
        return null;
    }

    public Car getCarById(UUID id){
        for (Car car : getAllCar()){
            if (car.getCarId().equals(id)){
                return car;
            }
        }
        throw new IllegalStateException("No such Car found");
    }


}
