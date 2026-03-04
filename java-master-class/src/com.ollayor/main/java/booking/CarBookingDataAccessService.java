package com.ollayor.main.java.booking;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarBookingDataAccessService implements CarBookingDAO {
    private CarBooking[] bookings = new CarBooking[100];
    private int bookingCount;


    public void addBooking(CarBooking booking) {
        if (bookingCount == bookings.length) {
            CarBooking[] temp = new CarBooking[bookings.length * 2];
            for (int i = 0; i < bookings.length; i++) {
                temp[i] = bookings[i];

            }
            bookings = temp;
        }
        bookings[bookingCount] = booking;
        bookingCount++;

    }

    @Override
    public CarBooking[] getBookings() {
        return bookings;

    }

}
