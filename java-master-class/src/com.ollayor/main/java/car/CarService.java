package com.ollayor.main.java.car;

import java.util.UUID;

public class CarService {
    private final CarArrayDataAccessService carArrayDataAccessService;

    public CarService(CarArrayDataAccessService carArrayDataAccessService) {
        this.carArrayDataAccessService = carArrayDataAccessService;
    }

    public Car[] getAllCar() {
        return carArrayDataAccessService.getCars();
    }

    public Car[] getAvailableCars(){
        int count = 0;
        for (Car car :getAllCar()){
            if (!car.isBooked()){
                count++;
            }
        }
        if (count == 0){
            throw new IllegalStateException("There is not any car");
        }
        Car[] cars = new Car[count];
        int index = 0;
        for (Car car : getAllCar()){
            if (!car.isBooked()){
                cars[index] = car;
                index++;

            }
        }
        return cars;
    }
    public Car[] getElectricCars(){
        int counts = 0;
        for (Car car :getAllCar()){
            if (!car.isBooked() && car.isElectric()){
                counts++;
            }
        }
        if (counts == 0){
            throw new IllegalStateException("For now there is not any electric cars available");
        }
        Car[] electricCars = new Car[counts];
        int indexes = 0;
        for (Car car : getAllCar()){
            if (!car.isBooked() && car.isElectric()){
                electricCars[indexes] = car;
                indexes++;

            }
        }
        return electricCars;
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
