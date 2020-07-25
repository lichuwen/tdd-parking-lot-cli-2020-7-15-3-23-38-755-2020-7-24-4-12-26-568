package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {
    @Test
    void should_return_wrong_message_when_fetch_given_wrong_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        CarTicket carTicket = new CarTicket();
        Car returnCar = parkingBoy.fetch(carTicket);
        String wrongMessage = parkingBoy.getWrongMessage();

        //then
        assertEquals("Unrecognized parking ticket.", wrongMessage);
    }
}
