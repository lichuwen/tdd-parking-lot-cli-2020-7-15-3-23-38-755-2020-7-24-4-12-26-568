package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private Map<CarTicket, Car> parkLots = new HashMap<>();

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Map<CarTicket, Car> getParkLots() {
        return parkLots;
    }

    public CarTicket store(Car car) {
        CarTicket carTicket = new CarTicket();
        if (!isEnoughPosition()) {
            return null;
        }
        parkLots.put(carTicket, car);
        return carTicket;
    }

    public Car take(CarTicket carTicket) {
        Car car = parkLots.get(carTicket);
        parkLots.remove(carTicket);
        return car;
    }

    public boolean isEnoughPosition() {
        return parkLots.size() < this.capacity;
    }

    public int getEmptyPosition() {
        return capacity - parkLots.size();
    }

}
