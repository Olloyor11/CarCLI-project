package com.ollayor.main.java.car;

import com.ollayor.main.java.user.User;

import java.math.BigDecimal;
import java.util.UUID;

public class CarDAO {
    static final Car[] cars;

    static {
        cars = new Car[]{
                new Car(Brand.BMW,
                        "AB12CDE",
                        new BigDecimal("45.00"),
                        false),

                new Car(Brand.MERCEDES,
                        "WWQ11911",
                        new BigDecimal("60.00"),
                        false),

                new Car(
                        Brand.TOYOTA,
                        "WWS99899",
                        new BigDecimal("35.00"),
                        false),

                new Car(Brand.TESLA,
                        "WWR44044",
                        new BigDecimal("80.00"),
                        true),

                new Car(Brand.TOYOTA,
                        "TO55YOT",
                        new BigDecimal("35.00"),
                        false),

                new Car(Brand.TESLA,
                        "TE99SLB",
                        new BigDecimal("90.00"),
                        true),

                new Car(Brand.BMW,
                        "BM77WXY",
                        new BigDecimal("50.00"),
                        false),

                new Car(Brand.TOYOTA,
                        "TO22YAB",
                        new BigDecimal("40.00"),
                        false)


        };
    }

    public Car[] getCars() {
        return cars;
    }
}