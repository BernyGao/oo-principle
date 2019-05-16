package parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLotList;

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket parking(Car intoCar) {

        Optional<ParkingLot> firstParkingLotOptional = parkingLotList
                .stream()
                .filter(ParkingLot::isNotFull)
                .max(Comparator.comparing(ParkingLot::getEmptySpaceNumber));

        if (!firstParkingLotOptional.isPresent()) {
            throw new NoParkingSpacesException();
        }

        Ticket ticket = firstParkingLotOptional.get().parking(intoCar);

        return ticket;
    }
}
