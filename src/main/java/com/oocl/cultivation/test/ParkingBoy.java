package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {

    private ParkingLot parkingLot;
    private String wrongMessage;
    private Map<String,String> wrongMessages = new HashMap<>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        wrongMessages.put("unRecognize","Unrecognized parking ticket.");
        wrongMessages.put("unProvide","Please provide your parking ticket.");
        wrongMessages.put("noPosition","Not enough position.");
    }

    public String getWrongMessage() {
        return wrongMessage;
    }

    public Map<String, String> getWrongMessages() {
        return wrongMessages;
    }

    public CarTicket park(Car car) {
        CarTicket ticket = parkingLot.store(car);
        if (ticket == null) {
            wrongMessage = wrongMessages.get("unProvide");
        }
        return ticket;
    }

    public Car fetch(CarTicket ticket) {
        if(ticket == null){
            wrongMessage = wrongMessages.get("unProvide");
            return null;
        }
        Car car = parkingLot.move(ticket);
        if (car == null)
            wrongMessage = wrongMessages.get("unRecognize");
        return car;
    }
}
