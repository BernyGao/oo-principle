package parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    public String name = "GRADUATE";

    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket parking(Car car) {

        Optional<ParkingLot> firstParkingLot = parkingLotList.stream().filter(ParkingLot::isNotFull).findFirst();

        if(!firstParkingLot.isPresent()){
            throw new NoParkingSpacesException();
        }

        Ticket ticket = firstParkingLot.get().parking(car);

        return ticket;
    }
}
