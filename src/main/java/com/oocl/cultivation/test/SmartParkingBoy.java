package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot(ArrayList<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .sorted(Comparator.comparingInt(ParkingLot::getEmptyPosition).reversed())
                .collect(Collectors.toList())
                .get(0);
    }
}
