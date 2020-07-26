package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {

    ArrayList<ParkingLot> parkingLots;
    private String wrongMessage;
    private Map<String,String> wrongMessages = new HashMap<>();

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
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
        ParkingLot parkingLot = chooseParkingLot(parkingLots);
        if(parkingLot.isEnoughPosition()){
            wrongMessage = wrongMessages.get("noPosition");
            return null;
        }
        CarTicket ticket = parkingLot.store(car);
        if (ticket == null) {
            wrongMessage = wrongMessages.get("unProvide");
        }
        return ticket;
    }

    public Car fetch(CarTicket ticket) {
        ParkingLot parkingLot = chooseParkingLot(parkingLots);
        if(ticket == null){
            wrongMessage = wrongMessages.get("unProvide");
            return null;
        }
        Car car = parkingLot.move(ticket);
        if (car == null)
            wrongMessage = wrongMessages.get("unRecognize");
        return car;
    }

    public ParkingLot chooseParkingLot(ArrayList<ParkingLot> parkingLots){
        ParkingLot suitParkingLot = parkingLots.get(0);
        for(ParkingLot parkinglot:parkingLots){
            if(!parkinglot.isEnoughPosition()){
                suitParkingLot = parkinglot;
            }
        }
        return suitParkingLot;
    }


}
