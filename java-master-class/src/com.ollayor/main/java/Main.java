package com.ollayor.main.java;

import com.ollayor.main.java.booking.CarBooking;
import com.ollayor.main.java.booking.CarBookingDataAccessService;
import com.ollayor.main.java.booking.CarBookingService;
import com.ollayor.main.java.car.Car;
import com.ollayor.main.java.car.CarArrayDataAccessService;
import com.ollayor.main.java.car.CarService;
import com.ollayor.main.java.user.User;
import com.ollayor.main.java.user.UserArrayDataAccessService;
import com.ollayor.main.java.user.UserService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();
        CarArrayDataAccessService carArrayDataAccessService = new CarArrayDataAccessService();
        CarBookingDataAccessService carBookingDataAccessService = new CarBookingDataAccessService();
        UserService userService = new UserService(userArrayDataAccessService);
        CarService carService = new CarService(carArrayDataAccessService);
        CarBookingService carBookingService = new CarBookingService(carService, userService, carBookingDataAccessService);

        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.println("" +
                    "1 - Book Car\n" +
                    "2 - View All User Booked Cars\n" +
                    "3 - View All Bookings\n" +
                    "4 - View Available Cars\n" +
                    "5 - View Available Electric Cars\n" +
                    "6 - View All Users\n" +
                    "7 - Exit");

            int scanner = scan.nextInt();
            scan.nextLine();

            if (scanner == 1) {
                System.out.println();
                System.out.println("Please enter your Id: ");

                try {


                    UUID idScanner = UUID.fromString(scan.nextLine());
                    User userId = userService.getUserById(idScanner);

                    if (userId == null) {
                        System.out.println("User not found");
                        continue;
                    }

                    System.out.println("Please enter starting date: ");
                    LocalDate startDate = LocalDate.parse(scan.nextLine());

                    System.out.println("Please enter Car returning date: ");
                    LocalDate endDate = LocalDate.parse(scan.nextLine());

                    System.out.println("Here All available cars for now: ");
                    for (Car availableCar : carService.getAvailableCars()) {
                        System.out.println();
                        System.out.println(availableCar);
                    }

                    System.out.println("Please enter Car Id: ");
                    UUID carIdScanner = UUID.fromString(scan.nextLine());
                    Car carId = carService.getCarById(carIdScanner);
                    if (carId == null) {
                        System.out.println("Car not found");
                        continue;
                    }
                    CarBooking booking = carBookingService.bookCar(userId.getUserId(), carId.getCarId(), startDate, endDate);

                    System.out.println("Your total price: " + booking.getTotalPrice());

                    System.out.println("Your booking is confirmed!");
                    System.out.println(booking.getBookedAt());

                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (scanner == 2) {
                System.out.println("Please enter your ID: ");

                try {
                    UUID idScanner = UUID.fromString(scan.nextLine());
                    User user = userService.getUserById(idScanner);

                    if (user == null) {
                        System.out.println("User not found");
                        continue;
                    }
                    for (CarBooking booking : carBookingService.getUserBooking(user)) {
                        System.out.println(booking);
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());

                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid UUID format");
                }

            }
            if (scanner == 3) {
                System.out.println("Here all bookings: ");
                try {
                    for (CarBooking booking : carBookingService.getAllBookings()) {
                        System.out.println(booking);
                    }

                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (scanner == 4) {
                System.out.println("Here are all available cars: ");

                try {
                    for (Car car : carService.getAvailableCars()) {
                        System.out.println(car);

                    }

                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (scanner == 5) {
                System.out.println("Here are all electric cars: ");
                try {
                    for (Car car : carService.getElectricCars()) {
                        System.out.println(car);
                    }

                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (scanner == 6) {
                System.out.println("Here are all users: ");
                try {
                    for (User users : userService.getAllUser()) {
                        System.out.println(users);
                    }

                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (scanner == 7) {
                break;
            }

        }
    }
}