package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        CarTicket carTicket = parkingLot.store(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_given_carTicket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.store(car);

        //when
        Car carReturn = parkingLot.take(carTicket);

        //then
        assertNotNull(carTicket);
        assertEquals(car, carReturn);
    }

    @Test
    void should_return_right_car_when_fetch_cars_given_correspond_carTicket() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket1 = parkingLot.store(car1);
        CarTicket carTicket2 = parkingLot.store(car2);

        //when
        Car carReturn = parkingLot.take(carTicket1);

        //then
        assertEquals(car1, carReturn);
    }

    @Test
    void should_return_no_car_when_fetch_given_wrong_carTicket() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket1 = parkingLot.store(car1);
        CarTicket carTicket2 = parkingLot.store(car2);
        CarTicket carTicket3 = new CarTicket();

        //when
        Car carReturn = parkingLot.take(carTicket3);

        //then
        assertNull(carReturn);
    }

    @Test
    void should_return_no_car_when_fetch_given_no_carTicket() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket1 = parkingLot.store(car1);
        CarTicket carTicket2 = parkingLot.store(car2);

        //when
        Car carReturn = parkingLot.take(null);

        //then
        assertNull(carReturn);
    }

    @Test
    void should_return_no_car_when_fetch_given_already_used_carTicket() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket1 = parkingLot.store(car1);

        //when
        Car carReturn1 = parkingLot.take(carTicket1);
        Car carReturn2 = parkingLot.take(carTicket1);

        //then
        assertNull(carReturn2);
    }

    @Test
    void should_return_no_ticket_when_park_given_capacity_over_10() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0; i < 10; i++) {
            parkingLot.store(new Car());
        }
        Car car11 = new Car();

        //when
        CarTicket carTicket = parkingLot.store(car11);

        //then
        assertNull(carTicket);
    }

}
