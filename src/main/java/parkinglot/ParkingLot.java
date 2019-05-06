package parkinglot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {

    private Set<String> carIdList = new HashSet();
    private long size;

    public void setSize(long size) {
        this.size = size;
    }


    public boolean parking(String carId) {
        if (carIdList.size() > size) {
            return false;
        }
        this.carIdList.add(carId);
        return true;
    }

    public boolean getCar(String carId) {
        if(this.carIdList.contains(carId)){
            return true;
        }
        return false;
    }
}
