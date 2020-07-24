package com.oocl.cultivation.test;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_catTicket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        asserNotNull(carTicket);
    }
}
