package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> ticketCarMapper = new HashMap();
    private long capacity;

    public ParkingLot(long capacity) {
        this.capacity = capacity;
    }

    public Ticket parking(Car car) {

        if (isFull()) {
            throw new NoParkingSpacesException();
        }

        Ticket ticket = new Ticket();
        ticketCarMapper.put(ticket, car);

        return ticket;
    }

    public Car takeCar(Ticket ticket) {

        Car car = ticketCarMapper.get(ticket);

        if (car == null) {
            throw new InvalidTicketException();
        }

        return car;
    }

    public boolean isFull() {
        return ticketCarMapper.size() >= capacity;
    }

    public boolean isNotFull() {
        return !isFull();
    }
}
