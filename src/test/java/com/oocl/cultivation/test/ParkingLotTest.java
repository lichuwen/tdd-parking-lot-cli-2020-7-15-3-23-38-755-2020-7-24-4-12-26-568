package com.oocl.cultivation.test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_catTicket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_given_carTicket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = new CarTicket();

        //when
        Car car = parkingLot.fetch(carTicket);

        //then
        assertNotNull(car);
    }
}
