package cc.oobootcamp;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.Car;
import parkinglot.InvalidTicketException;
import parkinglot.NoParkingSpacesException;
import parkinglot.ParkingBoy;
import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkinglot.TicketIsUsedException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParkingBoyTest {

    @Test
    public void given_a_car_and_a_parking_boy_and_3_parking_lot_and_first_parking_lot_is_not_full_when_parking_boy_parking_then_park_in_first_parking_lot_and_get_ticket() {

        long capacity1 = 100l;
        ParkingLot firstParkingLot = new ParkingLot(capacity1);
        long capacity2 = 100l;
        ParkingLot secondParkingLot = new ParkingLot(capacity2);
        long capacity3 = 100l;
        ParkingLot thirdParkingLot = new ParkingLot(capacity3);
        List<ParkingLot> parkingLotList = Stream.of(firstParkingLot, secondParkingLot, thirdParkingLot).collect(Collectors.toList());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car intoCar = new Car();

        Ticket ticket = parkingBoy.parking(intoCar);

        Car outCar = firstParkingLot.takeCar(ticket);
        Assert.assertEquals(intoCar, outCar);
    }


    @Test
    public void given_a_car_and_a_parking_boy_and_3_parking_lot_and_first_parking_lot_is_full_and_second_parking_lot_is_not_full_when_parking_boy_parking_then_park_in_second_parking_lot_and_get_ticket() {

        long capacity1 = 1l;
        ParkingLot firstParkingLot = new ParkingLot(capacity1);
        firstParkingLot.parking(new Car());
        long capacity2 = 100l;
        ParkingLot secondParkingLot = new ParkingLot(capacity2);
        long capacity3 = 100l;
        ParkingLot thirdParkingLot = new ParkingLot(capacity3);
        List<ParkingLot> parkingLotList = Stream.of(firstParkingLot, secondParkingLot, thirdParkingLot).collect(Collectors.toList());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car intoCar = new Car();

        Ticket ticket = parkingBoy.parking(intoCar);

        Car outCar = secondParkingLot.takeCar(ticket);
        Assert.assertEquals(intoCar, outCar);
    }

    @Test
    public void given_a_car_and_a_parking_boy_and_3_parking_lot_and_first_two_parking_lot_is_full_and_third_parking_lot_is_not_full_when_parking_boy_parking_then_park_in_third_parking_lot_and_get_ticket() {

        long capacity1 = 1l;
        ParkingLot firstParkingLot = new ParkingLot(capacity1);
        firstParkingLot.parking(new Car());
        long capacity2 = 1l;
        ParkingLot secondParkingLot = new ParkingLot(capacity2);
        secondParkingLot.parking(new Car());
        long capacity3 = 100l;
        ParkingLot thirdParkingLot = new ParkingLot(capacity3);
        List<ParkingLot> parkingLotList = Stream.of(firstParkingLot, secondParkingLot, thirdParkingLot).collect(Collectors.toList());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car intoCar = new Car();

        Ticket ticket = parkingBoy.parking(intoCar);

        Car outCar = thirdParkingLot.takeCar(ticket);
        Assert.assertEquals(intoCar, outCar);
    }

    @Test(expected = NoParkingSpacesException.class)
    public void given_a_car_and_a_parking_boy_and_2_full_parking_lot_when_parking_boy_parking_then_parking_failed() {

        long capacity1 = 1l;
        ParkingLot firstParkingLot = new ParkingLot(capacity1);
        firstParkingLot.parking(new Car());
        long capacity2 = 1l;
        ParkingLot secondParkingLot = new ParkingLot(capacity2);
        secondParkingLot.parking(new Car());
        List<ParkingLot> parkingLotList = Stream.of(firstParkingLot, secondParkingLot).collect(Collectors.toList());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car intoCar = new Car();

        parkingBoy.parking(intoCar);
    }

    @Test
    public void given_a_car_and_a_parking_boy_and_2_parking_lot_and_effective_ticket_when_parking_boy_take_car_then_take_correct_car() {

        long capacity1 = 100l;
        ParkingLot firstParkingLot = new ParkingLot(capacity1);
        firstParkingLot.parking(new Car());
        long capacity2 = 100l;
        ParkingLot secondParkingLot = new ParkingLot(capacity2);
        secondParkingLot.parking(new Car());
        List<ParkingLot> parkingLotList = Stream.of(firstParkingLot, secondParkingLot).collect(Collectors.toList());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car intoCar = new Car();
        Ticket ticket = parkingBoy.parking(intoCar);

        Car outCar = parkingBoy.takeCar(ticket);

        Assert.assertEquals(intoCar, outCar);
    }

    @Test(expected = InvalidTicketException.class)
    public void given_a_car_and_a_parking_boy_and_2_parking_lot_and_invalid_ticket_when_parking_boy_take_car_then_take_car_failed() {

        long capacity1 = 100l;
        ParkingLot firstParkingLot = new ParkingLot(capacity1);
        firstParkingLot.parking(new Car());
        long capacity2 = 100l;
        ParkingLot secondParkingLot = new ParkingLot(capacity2);
        secondParkingLot.parking(new Car());
        List<ParkingLot> parkingLotList = Stream.of(firstParkingLot, secondParkingLot).collect(Collectors.toList());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car intoCar = new Car();
        parkingBoy.parking(intoCar);
        Ticket invalidTicket = new Ticket();

        parkingBoy.takeCar(invalidTicket);
    }

    @Test(expected = TicketIsUsedException.class)
    public void given_a_car_and_a_parking_boy_and_2_parking_lot_and_used_ticket_when_parking_boy_take_car_then_take_car_failed() {

        long capacity1 = 100l;
        ParkingLot firstParkingLot = new ParkingLot(capacity1);
        firstParkingLot.parking(new Car());
        long capacity2 = 100l;
        ParkingLot secondParkingLot = new ParkingLot(capacity2);
        secondParkingLot.parking(new Car());
        List<ParkingLot> parkingLotList = Stream.of(firstParkingLot, secondParkingLot).collect(Collectors.toList());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Ticket ticket = parkingBoy.parking(new Car());
        parkingBoy.takeCar(ticket);

        parkingBoy.takeCar(ticket);
    }
}
