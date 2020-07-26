package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    void should_return_more_empty_parkingLot_when_park_given_2_parkingLots() {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.park(new Car());
        Car car = new Car();

        //when
        smartParkingBoy.park(car);

        //then
        assertEquals(9, parkingLots.get(0).getEmptyPosition());
        assertEquals(9, parkingLots.get(1).getEmptyPosition());
    }

}
