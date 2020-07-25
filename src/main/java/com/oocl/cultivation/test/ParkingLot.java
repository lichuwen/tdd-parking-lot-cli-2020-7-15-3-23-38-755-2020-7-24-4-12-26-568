package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket,Car> parkLots = new HashMap<>();
    public CarTicket park(Car car){
        CarTicket carTicket = new CarTicket();
        parkLots.put(carTicket,car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        Car car = parkLots.get(carTicket);
        parkLots.remove(carTicket);
        return car;
    }
}
