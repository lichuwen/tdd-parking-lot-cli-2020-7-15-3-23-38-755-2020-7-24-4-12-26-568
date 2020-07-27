package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot(ArrayList<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .sorted(new Comparator<ParkingLot>(){
                       @Override
                       public int compare(ParkingLot parkingLot1, ParkingLot parkingLot2) {
                           return Double.compare(parkingLot1.getEmptyPosition() * 1.0 / parkingLot1.getCapacity(),parkingLot2.getEmptyPosition() * 1.0 / parkingLot2.getCapacity());
                       }
                }
                .reversed())
                .collect(Collectors.toList())
                .get(0);
    }
}
