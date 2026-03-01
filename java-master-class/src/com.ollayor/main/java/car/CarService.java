package com.ollayor.main.java.car;

import static com.ollayor.main.java.car.CarDAO.cars;

public class CarService {
    private Car car;
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public Car[] getAllCar() {
        return carDAO.getCars();
    }

    public Car[] getAvailableCars(){
        int count = 0;
        for (Car car :getAllCar()){
            if (!car.isBooked()){
                count++;
            }
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
}
