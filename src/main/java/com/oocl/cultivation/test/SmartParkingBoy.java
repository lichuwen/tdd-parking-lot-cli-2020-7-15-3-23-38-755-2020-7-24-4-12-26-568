package com.oocl.cultivation.test;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot(ArrayList<ParkingLot> parkingLots) {
        ParkingLot suitParkingLot = parkingLots.get(0);
        int largestEmptyPosition = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getEmptyPosition() > largestEmptyPosition) {
                suitParkingLot = parkingLot;
                largestEmptyPosition = parkingLot.getEmptyPosition();
            }
        }
        return suitParkingLot;
    }
}
