package examples.partkingLot;

public class TwoVehilerParkingFee implements ParkingFee{

  @Override
  public int calculateFee(int hours) {
    return 10*hours;
  }
}
