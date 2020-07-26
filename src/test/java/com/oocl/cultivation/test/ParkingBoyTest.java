package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingBoyTest {
    @Test
    void should_return_wrong_message_when_fetch_given_wrong_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket carTicket = new CarTicket();

        //when
        Car returnCar = parkingBoy.fetch(carTicket);
        String wrongMessage = parkingBoy.getWrongMessage();

        //then
        assertEquals("Unrecognized parking ticket.", wrongMessage);
    }

    @Test
    void should_return_wrong_message_when_fetch_given_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        //when
        Car returnCar1 = parkingBoy.fetch(carTicket);
        Car returnCar2 = parkingBoy.fetch(carTicket);
        String wrongMessage = parkingBoy.getWrongMessage();

        //then
        assertEquals("Unrecognized parking ticket.", wrongMessage);
    }

    @Test
    void should_return_wrong_message_when_fetch_given_no_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket carTicket = null;

        //when
        Car returnCar1 = parkingBoy.fetch(carTicket);
        String wrongMessage = parkingBoy.getWrongMessage();

        //then
        assertEquals("Please provide your parking ticket.", wrongMessage);
    }

    @Test
    void should_return_wrong_message_when_park_given_no_position(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i=0; i<10; i++){
            parkingBoy.park(new Car());
        }
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        //when
        String wrongMessage = parkingBoy.getWrongMessage();

        //then
        assertEquals("Not enough position.", wrongMessage);
    }
}
