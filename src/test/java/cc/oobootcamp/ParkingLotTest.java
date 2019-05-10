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
    public void given_a_parkinglot_with_enough_space_when_parking_then_parking_success() {

        long capacity = 100l;
        ParkingLot parkingLot = new ParkingLot(capacity);

        Car car = new Car();
        Ticket ticket = parkingLot.parking(car);

        Assert.assertNotNull(ticket);
    }

    @Test(expected = NoParkingSpacesException.class)
    public void give_a_parkinglot_with_not_enough_space_when_parking_then_parking_failed() {

        long capacity = 0l;
        ParkingLot parkingLot = new ParkingLot(capacity);

        Car car = new Car();
        parkingLot.parking(car);
    }

    @Test
    public void give_ticket_which_is_matched_with_carList_when_get_car_then_get_success() {

        long capacity = 100l;
        ParkingLot parkingLot = new ParkingLot(capacity);

        Car intoCar = new Car();
        Ticket ticket = parkingLot.parking(intoCar);

        Car outCar = parkingLot.takeCar(ticket);

        Assert.assertEquals(intoCar, outCar);
    }

    @Test(expected = InvalidTicketException.class)
    public void give_ticket_which_is_not_matched_with_carList_when_get_car_then_get_failed() {

        long capacity = 100l;
        ParkingLot parkingLot = new ParkingLot(capacity);

        Ticket invalidTicket = new Ticket();

        Car car = new Car();
        parkingLot.parking(car);

        parkingLot.takeCar(invalidTicket);
    }

}
