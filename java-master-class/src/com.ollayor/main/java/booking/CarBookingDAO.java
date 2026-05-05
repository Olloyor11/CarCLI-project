package com.ollayor.main.java.booking;

import java.util.List;

public interface CarBookingDAO {
    List<CarBooking> getBookings();

    void addBooking(CarBooking booking);


}
