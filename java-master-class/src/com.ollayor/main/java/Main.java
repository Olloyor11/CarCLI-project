package com.ollayor.main.java;

import com.ollayor.main.java.booking.CarBooking;
import com.ollayor.main.java.booking.CarBookingDAO;
import com.ollayor.main.java.booking.CarBookingService;
import com.ollayor.main.java.car.Car;
import com.ollayor.main.java.car.CarDAO;
import com.ollayor.main.java.car.CarService;
import com.ollayor.main.java.user.User;
import com.ollayor.main.java.user.UserDAO;
import com.ollayor.main.java.user.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        CarDAO carDAO = new CarDAO();
        CarBookingDAO carBookingDAO = new CarBookingDAO();
        UserService userService = new UserService(userDAO);
        CarService carService = new CarService(carDAO);
        CarBookingService carBookingService = new CarBookingService(carBookingDAO);

        Scanner scan = new Scanner(System.in);





        while (true){
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

            if (scanner == 1){
                System.out.println();
                System.out.println("Please enter your Id: ");
                UUID idScanner = UUID.fromString(scan.nextLine());
                User user = userService.getUserById(idScanner);
                if (user == null){
                    System.out.println("User not found");
                    continue;
                }
                for (Car availableCar : carService.getAvailableCars()){
                    System.out.println();
                    System.out.println("Here All available cars for now: " + availableCar);
                }
                System.out.println("Please enter the registration number of the car you wanted to rent: ");
                String regNumberScanner = scan.nextLine();
                Car car = carService.getCarByRegNumber(regNumberScanner);
                if (car == null){
                    System.out.println("Car not found");
                    continue;
                }
                carBookingService.bookCar(user,car);

            }
            if (scanner == 2){
                System.out.println("Please enter your ID: ");

                UUID idScanner = UUID.fromString(scan.nextLine());
                User user = userService.getUserById(idScanner);

                if (user == null){
                    System.out.println("User not found");
                    continue;
                }

                carBookingService.getUserBooking(user);

                for (CarBooking booking : carBookingService.getUserBooking(user)){
                    System.out.println(booking);
                }

            }
            if (scanner == 3){
                System.out.println("Here all bookings: ");
                for (CarBooking booking : carBookingService.getAllBookings()){
                    System.out.println(booking);
                }
            }

            if (scanner == 4){
                System.out.println("Here are all available cars: ");
                for (Car car : carService.getAvailableCars()){
                    System.out.println(car);

                }
            }

            if (scanner == 5){
                System.out.println("Here are all electric cars: ");
                for (Car car : carService.getElectricCars()){
                    System.out.println(car);
                }
            }

            if (scanner == 6) {
                System.out.println("Here are all users: ");
                for (User users : userService.getAllUser()) {
                    System.out.println(users);
                }
            }

            if (scanner == 7){
                break;
            }




        }


    }
}
