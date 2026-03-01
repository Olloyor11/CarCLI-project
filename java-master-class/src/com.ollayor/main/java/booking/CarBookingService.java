package com.ollayor.main.java.booking;

import com.ollayor.main.java.car.CarDAO;
import com.ollayor.main.java.user.User;
import com.ollayor.main.java.car.Car;
import com.ollayor.main.java.user.UserDAO;

import java.time.LocalDate;

public class CarBookingService {
    private final CarBookingDAO carBookingDAO;


    public CarBookingService(CarBookingDAO carBookingDAO) {


        this.carBookingDAO = carBookingDAO;
    }

    public void bookCar(User user, Car car) {
        CarBooking booking = new CarBooking(user, car);
        if (!car.isBooked()) {
            car.setBooked(true);
            carBookingDAO.addBooking(booking);
        }
    }

    public CarBooking[] getAllBookings() {
        int count = 0;
        for (CarBooking booking : carBookingDAO.getBookings()){
            if (booking != null){
                count++;
            }
        }
        CarBooking[] bookings = new CarBooking[count];
        int index = 0;
        for (CarBooking booking : carBookingDAO.getBookings()){
            if (booking != null){
                bookings[index] = booking;
                index++;
            }
        }
        return bookings;
    }

    public CarBooking[] getUserBooking(User user) {
        int count = 0;
        for (CarBooking booking : carBookingDAO.getBookings()) {
            if (booking != null && booking.getUserDetails().getId().equals(user.getId())) {
                count++;
            }
        }
        CarBooking[] bookings = new CarBooking[count];
        int index = 0;
        for (CarBooking booking : getAllBookings()) {
            if (booking != null && booking.getUserDetails().getId().equals(user.getId())) {
                bookings[index] = booking;
                index++;
            }
        }
        return bookings;

    }

}

