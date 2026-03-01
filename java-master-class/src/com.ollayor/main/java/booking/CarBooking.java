package com.ollayor.main.java.booking;

import com.ollayor.main.java.car.Car;
import com.ollayor.main.java.user.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CarBooking {
    private UUID id;
    private User userDetails;
    private Car carDetails;
    private LocalDateTime bookedDateTime;
    private BookingStatus status;


    public CarBooking(User userDetails, Car carDetails) {
        this.id = UUID.randomUUID();
        this.userDetails = userDetails;
        this.carDetails = carDetails;
        this.bookedDateTime = LocalDateTime.now();
        this.status = BookingStatus.ACTIVE;

    }

    public UUID getId() {
        return id;
    }

    public Car getCarDetails() {
        return carDetails;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public LocalDateTime getBookedDateTime() {
        return bookedDateTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "id=" + id +
                ", userDetails=" + userDetails +
                ", carDetails=" + carDetails +
                ", bookingDates=" + bookedDateTime +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return status == that.status && Objects.equals(id, that.id) && Objects.equals(userDetails, that.userDetails) && Objects.equals(carDetails, that.carDetails) && Objects.equals(bookedDateTime, that.bookedDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userDetails, carDetails, bookedDateTime, status);
    }
}
