package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private Map<CarTicket,Car> parkLots = new HashMap<>();

    public ParkingLot() {
        this.capacity = 10;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<CarTicket, Car> getParkLots() {
        return parkLots;
    }

    public CarTicket park(Car car){
        CarTicket carTicket = new CarTicket();
        if(parkLots.size() >= capacity){
            return null;
        }
        parkLots.put(carTicket,car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        Car car = parkLots.get(carTicket);
        parkLots.remove(carTicket);
        return car;
    }
}
