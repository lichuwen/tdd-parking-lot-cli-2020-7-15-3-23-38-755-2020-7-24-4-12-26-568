package com.oocl.cultivation.test;

import java.util.ArrayList;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot(ArrayList<ParkingLot> parkingLots) {
        ParkingLot suitParkingLot = parkingLots.get(0);
        double highRateLot = 0, parkingLotRate;
        for (ParkingLot parkingLot : parkingLots) {
            parkingLotRate = parkingLot.getEmptyPosition() * 1.0 / parkingLot.getCapacity();
            if (parkingLotRate > highRateLot) {
                suitParkingLot = parkingLot;
                highRateLot = parkingLotRate;
            }
        }
        return suitParkingLot;
    }
}
