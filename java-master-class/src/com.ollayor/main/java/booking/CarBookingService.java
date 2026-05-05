package com.ollayor.main.java.booking;

import com.ollayor.main.java.car.Car;
import com.ollayor.main.java.car.CarService;
import com.ollayor.main.java.user.User;
import com.ollayor.main.java.user.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarBookingService {

    private final CarService carService;
    private final UserService userService;
    private final CarBookingDAO carBookingDAO;


    public CarBookingService(CarService carService, UserService userService, CarBookingDAO carBookingDAO) {
        this.carService = carService;
        this.userService = userService;
        this.carBookingDAO = carBookingDAO;
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

        carBookingDAO.addBooking(booking);

        return booking;
    }


    public List<CarBooking> getAllBookings() {
        List<CarBooking> booking = carBookingDAO.getBookings();

        if (booking.isEmpty()) {
            throw new IllegalStateException("There is no active booking available!");
        }
        return booking;
    }

    public List<CarBooking> getUserBooking(UUID id) {
        List<CarBooking> bookings = carBookingDAO
                .getBookings()
                .stream()
                .filter(carBooking ->
                        carBooking
                                .getUserDetails()
                                .getUserId()
                                .equals(id)).collect(Collectors.toCollection(ArrayList::new));
        if (bookings.isEmpty()){
            throw new IllegalStateException("No bookings found for this user.");
        }
        return bookings;

    }

}

