package cc.oobootcamp;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.Car;
import parkinglot.ParkingBoy;
import parkinglot.ParkingLot;
import parkinglot.Ticket;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmartParkingBoyTest {

    @Test
    public void should_park_in_first_parking_lot_and_get_ticket_when_smart_parking_boy_parking_given_a_car_and_a_smart_parking_boy_and_2_parking_lot_and_first_parking_lot_has_2_empty_space_and_second_parking_lot_has_1_empty_space() {


        Car intoCar = new Car();
        SmartParkingBoy smartPakingBoy;
        Object ticket=smartPakingBoy.parking(intoCar);
        ParkingLot firstParkingLot;



        Car outCarFromFirstParkingLot=firstParkingLot.take(ticket);
        Assert.assertEquals(intoCar,outCarFromFirstParkingLot);


    }

}
