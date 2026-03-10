package com.ollayor.main.java.booking;

import java.util.ArrayList;

public class CarBookingDataAccessService implements CarBookingDAO {
    private ArrayList<CarBooking> bookings = new ArrayList<>();


    public void addBooking(CarBooking booking) {
        bookings.add(booking);
    }


    @Override
    public ArrayList<CarBooking> getBookings() {
        return bookings;

    }

}
