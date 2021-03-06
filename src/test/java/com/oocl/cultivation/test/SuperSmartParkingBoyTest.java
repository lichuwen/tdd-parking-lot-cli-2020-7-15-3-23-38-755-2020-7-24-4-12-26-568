package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    void should_return_larger_available_parkingLot_when_park_given_2_parkingLots_with_different_capacity() {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(8));
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        for (int i = 0; i < 2; i++) {
            superSmartParkingBoy.park(new Car());
        }
        Car car = new Car();

        //when
        superSmartParkingBoy.park(car);

        //then
        assertEquals(7, parkingLots.get(0).getEmptyPosition());
        assertEquals(8, parkingLots.get(1).getEmptyPosition());
    }
}
