package parkinglot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingLot {

    private Map<Ticket, Car> ticketCarMapper = new HashMap();
    private long capacity;

    private Set<Ticket> ticketUsingRecord = new HashSet<>();

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

        if (ticketUsingRecord.contains(ticket)) {
            throw new TicketIsUsedException();
        }

        Car car = ticketCarMapper.get(ticket);

        if (car == null) {
            throw new InvalidTicketException();
        }

        ticketCarMapper.remove(ticket);

        ticketUsingRecord.add(ticket);

        return car;
    }

    public boolean containsCar(Ticket ticket) {
        return ticketCarMapper.containsKey(ticket);
    }

    public boolean isFull() {
        return ticketCarMapper.size() >= capacity;
    }

    public boolean isNotFull() {
        return !isFull();
    }
}
