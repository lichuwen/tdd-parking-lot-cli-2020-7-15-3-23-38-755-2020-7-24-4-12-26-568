package com.oocl.cultivation.test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_given_carTicket(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket carTicket = parkingLot.park(car);
        Car carReturn = parkingLot.fetch(carTicket);

        //then
        assertNotNull(carTicket);
        assertEquals(car,carReturn);
    }

    @Test
    void should_return_right_car_when_fetch_cars_given_correspond_carTicket(){
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket carTicket1 = parkingLot.park(car1);
        CarTicket carTicket2 = parkingLot.park(car2);
        Car carReturn = parkingLot.fetch(carTicket1);

        //then
        assertEquals(car1,carReturn);
    }

    @Test
    void should_return_no_car_when_fetch_given_wrong_carTicket(){
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket carTicket1 = parkingLot.park(car1);
        CarTicket carTicket2 = parkingLot.park(car2);
        CarTicket carTicket3 = new CarTicket();
        Car carReturn = parkingLot.fetch(carTicket3);

        //then
        assertNull(carReturn);
    }

    @Test
    void should_return_no_car_when_fetch_given_no_carTicket(){
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket carTicket1 = parkingLot.park(car1);
        CarTicket carTicket2 = parkingLot.park(car2);
        Car carReturn = parkingLot.fetch(null);

        //then
        assertNull(carReturn);
    }

}
