package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_wrong_message_when_fetch_given_wrong_ticket(){
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
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
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
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
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
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
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
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

    @Test
    void should_return_ticket_when_park_given_over_10_cars_and_2_parkingLots(){
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for(int i=0; i<10; i++){
            parkingBoy.park(new Car());
        }
        Car car11 = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car11);

        //then
        assertNotNull(carTicket);
    }
}
