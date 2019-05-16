package cc.oobootcamp;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.Car;
import parkinglot.NoParkingSpacesException;
import parkinglot.ParkingLot;
import parkinglot.SmartParkingBoy;
import parkinglot.Ticket;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmartParkingBoyTest {

    @Test
    public void should_park_in_first_parking_lot_and_get_ticket_when_smart_parking_boy_parking_given_a_car_and_a_smart_parking_boy_and_2_parking_lot_and_first_parking_lot_has_2_empty_space_and_second_parking_lot_has_1_empty_space() {

        ParkingLot firstParkingLot = new ParkingLot(2L);
        ParkingLot secondParkingLot = new ParkingLot(1L);
        SmartParkingBoy smartParkingBoy = createSmartParkingBoy(firstParkingLot, secondParkingLot);
        Car intoCar = new Car();

        Ticket ticket = smartParkingBoy.parking(intoCar);

        Car outCarFromFirstParkingLot = firstParkingLot.take(ticket);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(intoCar, outCarFromFirstParkingLot);
    }

    @Test
    public void should_park_in_second_parking_lot_and_get_ticket_when_smart_parking_boy_parking_given_a_car_and_a_smart_parking_boy_and_2_parking_lot_and_first_parking_lot_has_1_empty_space_and_second_parking_lot_has_2_empty_space() {

        ParkingLot firstParkingLot = new ParkingLot(1L);
        ParkingLot secondParkingLot = new ParkingLot(2L);
        SmartParkingBoy smartParkingBoy = createSmartParkingBoy(firstParkingLot, secondParkingLot);
        Car intoCar = new Car();

        Ticket ticket = smartParkingBoy.parking(intoCar);

        Car outCarFromSecondParkingLot = secondParkingLot.take(ticket);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(intoCar, outCarFromSecondParkingLot);
    }

    @Test
    public void should_park_in_first_parking_lot_and_get_ticket_when_smart_parking_boy_parking_given_a_car_and_a_smart_parking_boy_and_2_parking_lot_and_first_parking_lot_has_1_empty_space_and_second_parking_lot_has_1_empty_space() {

        ParkingLot firstParkingLot = new ParkingLot(1L);
        ParkingLot secondParkingLot = new ParkingLot(1L);
        SmartParkingBoy smartParkingBoy = createSmartParkingBoy(firstParkingLot, secondParkingLot);
        Car intoCar = new Car();

        Ticket ticket = smartParkingBoy.parking(intoCar);

        Car outCarFromFirstParkingLot = firstParkingLot.take(ticket);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(intoCar, outCarFromFirstParkingLot);
    }

    @Test(expected = NoParkingSpacesException.class)
    public void should_parking_failed_when_smart_parking_boy_parking_given_a_car_and_a_smart_parking_boy_and_2_full_parking_lot() {

        ParkingLot firstParkingLot = new ParkingLot(1L);
        firstParkingLot.parking(new Car());
        ParkingLot secondParkingLot = new ParkingLot(1L);
        secondParkingLot.parking(new Car());
        SmartParkingBoy smartParkingBoy = createSmartParkingBoy(firstParkingLot, secondParkingLot);
        Car intoCar = new Car();

        smartParkingBoy.parking(intoCar);
    }

    private SmartParkingBoy createSmartParkingBoy(ParkingLot firstParkingLot, ParkingLot secondParkingLot) {
        return new SmartParkingBoy(Stream.of(firstParkingLot, secondParkingLot).collect(Collectors.toList()));
    }

}
