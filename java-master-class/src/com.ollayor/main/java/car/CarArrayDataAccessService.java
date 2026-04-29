package com.ollayor.main.java.car;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarArrayDataAccessService implements CarDAO {
    static final List<Car> cars = new ArrayList<>();


    static {
        cars.add(new Car(UUID.fromString("2ea85178-fada-4279-9d5e-eea627049fa2"), Brand.BMW, "AB12CDE", new BigDecimal("45.00"), false));
                cars.add(new Car(UUID.fromString("576590ff-57a1-4df3-8430-79980eb42343"), Brand.MERCEDES, "WWQ11911", new BigDecimal("60.00"), false));
                cars.add(new Car(UUID.fromString("9d818235-ce3b-40e8-b74a-3674985c6bcd"), Brand.TOYOTA, "WWS99899", new BigDecimal("35.00"), false));
                cars.add(new Car(UUID.fromString("87cb62d9-d262-4174-b1b2-957f9e2a1f40"), Brand.TESLA, "WWR44044", new BigDecimal("80.00"), true));
                cars.add(new Car(UUID.fromString("48f685ee-e174-4055-b644-68b93cd5116f"), Brand.TOYOTA, "TO55YOT", new BigDecimal("35.00"), false));
                cars.add(new Car(UUID.fromString("fe5b09ca-1593-4813-8cf4-6566d4b0349c"), Brand.TESLA, "TE99SLB", new BigDecimal("90.00"), true));
                cars.add(new Car(UUID.fromString("b6f31a2f-cdf1-4a5b-82ce-9c3a243b3ebe"), Brand.BMW, "BM77WXY", new BigDecimal("50.00"), false));
                cars.add(new Car(UUID.fromString("42004f7a-0d04-45d7-807c-dbacf35db2bb"), Brand.TOYOTA, "TO22YAB", new BigDecimal("40.00"), false));

    }

    @Override
    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}


