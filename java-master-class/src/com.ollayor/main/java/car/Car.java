package com.ollayor.main.java.car;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Car {
    private UUID carId;
    private Brand brand;
    private String regNumber;
    private BigDecimal rentalPricePerDay;
    private boolean isElectric;
    private boolean isBooked;

    public Car(UUID carId, Brand brand, String regNumber, BigDecimal rentalPricePerDay, boolean isElectric) {
        this.carId = carId;
        this.brand = brand;
        this.regNumber = regNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isElectric = isElectric;
        this.isBooked = false;
    }

    public UUID getCarId(){
        return carId;
    }

    public Brand getBrand() {
        return brand;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public String getRegNumber() {
        return regNumber;
    }


    public boolean isElectric() {
        return isElectric;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand=" + brand +
                ", regNumber='" + regNumber + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", isElectric=" + isElectric +
                ", isBooked=" + isBooked +
                '}';
    }
}
