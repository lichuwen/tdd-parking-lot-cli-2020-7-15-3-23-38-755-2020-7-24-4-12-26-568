package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ParkingBoy implements bestChoiceOfParkingLots {

    private ArrayList<ParkingLot> parkingLots;
    private String wrongMessage;
    private Map<String, String> wrongMessages = new HashMap<>();

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        wrongMessages.put("unRecognize", "Unrecognized parking ticket.");
        wrongMessages.put("unProvide", "Please provide your parking ticket.");
        wrongMessages.put("noPosition", "Not enough position.");
    }

    public String getWrongMessage() {
        return wrongMessage;
    }

    public CarTicket park(Car car) {
        ParkingLot parkingLot = chooseParkingLot(parkingLots);
        if (!parkingLot.isEnoughPosition()) {
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
        if (ticket == null) {
            wrongMessage = wrongMessages.get("unProvide");
            return null;
        }
        Car car = parkingLot.take(ticket);
        if (car == null)
            wrongMessage = wrongMessages.get("unRecognize");
        return car;
    }

    @Override
    public ParkingLot chooseParkingLot(ArrayList<ParkingLot> parkingLots) {
        ParkingLot suitParkingLot = parkingLots.get(0);
        if(parkingLots.size() > 1){
            suitParkingLot = parkingLots.stream()
                    .filter(ParkingLot::isEnoughPosition)
                    .collect(Collectors.toList()).get(0);
        }
        return suitParkingLot;
    }
}

