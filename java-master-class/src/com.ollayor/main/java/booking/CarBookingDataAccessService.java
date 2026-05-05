package com.ollayor.main.java.booking;

import java.util.ArrayList;
import java.util.List;

public class CarBookingDataAccessService implements CarBookingDAO {
    private List<CarBooking> bookings = new ArrayList<>();


    public void addBooking(CarBooking booking) {
        bookings.add(booking);
    }


    @Override
    public List<CarBooking> getBookings() {
        return bookings;

    }

}
