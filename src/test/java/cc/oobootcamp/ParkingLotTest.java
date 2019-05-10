package cc.oobootcamp;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.Car;
import parkinglot.InvalidTicketException;
import parkinglot.NoParkingSpacesException;
import parkinglot.ParkingLot;
import parkinglot.Ticket;

public class ParkingLotTest {

    @Test
    public void should_parking_success_when_parking_given_a_parkinglot_with_enough_space() {

        long capacity = 100l;
        ParkingLot parkingLot = new ParkingLot(capacity);

        Car car = new Car();
        Ticket ticket = parkingLot.parking(car);

        Assert.assertNotNull(ticket);
    }

    @Test(expected = NoParkingSpacesException.class)
    public void should_parking_failed_when_parking_given_a_parkinglot_with_not_enough_space() {

        long capacity = 0l;
        ParkingLot parkingLot = new ParkingLot(capacity);

        Car car = new Car();
        parkingLot.parking(car);
    }

    @Test
    public void should_get_success_give_ticket_which_is_matched_with_carList_when_get_car() {

        long capacity = 100l;
        ParkingLot parkingLot = new ParkingLot(capacity);

        Car intoCar = new Car();
        Ticket ticket = parkingLot.parking(intoCar);

        Car outCar = parkingLot.takeCar(ticket);

        Assert.assertEquals(intoCar, outCar);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_get_failed__when_get_car_give_ticket_which_is_not_matched_with_carList() {

        long capacity = 100l;
        ParkingLot parkingLot = new ParkingLot(capacity);

        Ticket invalidTicket = new Ticket();

        Car car = new Car();
        parkingLot.parking(car);

        parkingLot.takeCar(invalidTicket);
    }

}
