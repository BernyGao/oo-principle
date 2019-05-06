package cc.oobootcamp;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.ParkingLot;

public class ParkingLotTest {

    @Test
    public void given_a_parkinglot_with_enough_space_when_parking_then_parking_success(){

        ParkingLot parkingLot = new ParkingLot();

        long size = 100l;

        parkingLot.setSize(size);

        String carId = "001";

        boolean parkingResult = parkingLot.parking(carId);

        Assert.assertTrue(parkingResult);
    }

     @Test
     public void give_a_parkinglot_with_not_enough_space_when_parking_then_parking_failed(){

         ParkingLot parkingLot = new ParkingLot();

         long size = 0l;

         parkingLot.setSize(size);

         String carId = "001";

         boolean parkingResult = parkingLot.parking(carId);

         Assert.assertFalse(parkingResult);
     }

     @Test
     public void give_ticket_which_is_matched_with_carList_when_get_car_then_get_success(){

         ParkingLot parkingLot = new ParkingLot();

         long size = 100l;

         parkingLot.setSize(size);

         String carId = "001";

         parkingLot.parking(carId);

         boolean getCarResult = parkingLot.getCar(carId);

         Assert.assertTrue(getCarResult);

     }

     @Test
     public void give_ticket_which_is_not_matched_with_carList_when_get_car_then_get_failed(){

         String carId = "002";

         ParkingLot parkingLot = new ParkingLot();

         boolean getCarResult = parkingLot.getCar(carId);

         Assert.assertFalse(getCarResult);

     }








}
