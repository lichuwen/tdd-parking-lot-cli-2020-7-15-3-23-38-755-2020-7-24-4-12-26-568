package com.oocl.cultivation.test;

public class ParkingBoy {

    private ParkingLot parkingLot;

    private String wrongMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getWrongMessage() {
        return wrongMessage;
    }

    public Car fetch(CarTicket ticket) {
        return new Car();
    }
}
