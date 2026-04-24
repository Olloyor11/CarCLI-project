package com.ollayor.main.java.booking;

import com.ollayor.main.java.car.Car;
import com.ollayor.main.java.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class CarBooking {
    private UUID id;
    private User userDetails;
    private Car carDetails;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate bookedAt;
    private BigDecimal totalPrice;
    private BookingStatus status;

    public CarBooking(User userDetails, Car carDetails, LocalDate startDate, LocalDate endDate, BigDecimal totalPrice) {
        this.id = UUID.randomUUID();
        this.userDetails = userDetails;
        this.carDetails = carDetails;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = BookingStatus.ACTIVE;
        this.totalPrice = totalPrice;
        this.bookedAt = LocalDate.now();
    }

    public LocalDate getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(LocalDate bookedAt) {
        this.bookedAt = bookedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }

    public Car getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(Car carDetails) {
        this.carDetails = carDetails;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking booking = (CarBooking) o;
        return Objects.equals(id, booking.id) && Objects.equals(userDetails, booking.userDetails) && Objects.equals(carDetails, booking.carDetails) && Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate) && Objects.equals(totalPrice, booking.totalPrice) && status == booking.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userDetails, carDetails, startDate, endDate, totalPrice, status);
    }
}

