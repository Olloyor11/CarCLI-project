package com.ollayor.main.java.booking;

import com.ollayor.main.java.car.CarService;
import com.ollayor.main.java.user.User;
import com.ollayor.main.java.car.Car;
import com.ollayor.main.java.user.UserArrayDataAccessService;
import com.ollayor.main.java.user.UserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

import java.time.LocalDate;

public class CarBookingService {

    private final CarService carService;
    private final UserService userService;
    private final CarBookingDataAccessService carBookingDataAccessService;


    public CarBookingService(CarService carService, UserService userService, CarBookingDataAccessService carBookingDataAccessService) {
        this.carService = carService;
        this.userService = userService;
        this.carBookingDataAccessService = carBookingDataAccessService;
    }

    public CarBooking bookCar(UUID userId, UUID carId, LocalDate startDate, LocalDate
            endDate) {
        User user = userService.getUserById(userId);
        if (user == null) throw new IllegalStateException("User not found");

        Car car = carService.getCarById(carId);
        if (car == null) throw new IllegalStateException("Car is not found");

        if (startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The start time can not be in the past!");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("The end date must be after the start date!");
        }

        if (car.isBooked()) {
            throw new IllegalArgumentException("Car is not active");
        }

        int numDays = Math.toIntExact(ChronoUnit.DAYS.between(startDate, endDate));
        BigDecimal totalPrice = car.getRentalPricePerDay().multiply(BigDecimal.valueOf(numDays));

        CarBooking booking = new CarBooking(user, car, startDate, endDate, totalPrice);

        car.setBooked(true);

        carBookingDataAccessService.addBooking(booking);

        return booking;
    }

    public ArrayList<CarBooking> getAllBookings() {
        ArrayList<CarBooking> booking = carBookingDataAccessService.getBookings();

        if (booking.isEmpty()) {
            throw new IllegalStateException("There is no active booking available!");
        }
        return booking;
    }

    public ArrayList<CarBooking> getUserBooking(User user) {
        ArrayList<CarBooking> bookings = new ArrayList<>();
        for (CarBooking booking : carBookingDataAccessService.getBookings()) {
            if (booking.getUserDetails().getUserId().equals(user.getUserId())) {
                bookings.add(booking);
            }
        }

        if (bookings.isEmpty()) {
            throw new IllegalStateException("There is no active booking available!");
        }

        return bookings;

    }


}

