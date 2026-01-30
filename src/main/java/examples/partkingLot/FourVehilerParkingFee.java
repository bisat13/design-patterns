package examples.partkingLot;

public class FourVehilerParkingFee implements ParkingFee{

  @Override
  public int calculateFee(int hours) {
    return 20*hours;
  }
}
