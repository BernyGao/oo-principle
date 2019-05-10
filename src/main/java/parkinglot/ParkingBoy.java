package parkinglot;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    private String name = "GRADUATE";

    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket parking(Car car) {

        Optional<ParkingLot> firstParkingLotOptional = parkingLotList
                .stream()
                .filter(ParkingLot::isNotFull)
                .findFirst();

        if (!firstParkingLotOptional.isPresent()) {
            throw new NoParkingSpacesException();
        }

        Ticket ticket = firstParkingLotOptional
                .get()
                .parking(car);

        return ticket;
    }

    public Car takeCar(Ticket ticket) {

        Optional<ParkingLot> parkingLotOptional = parkingLotList
                .stream()
                .filter(parkingLot -> parkingLot.containsCar(ticket))
                .findFirst();

        if (!parkingLotOptional.isPresent()) {
            throw new InvalidTicketException();
        }

        Car car = parkingLotOptional
                .get()
                .takeCar(ticket);

        return car;
    }
}
