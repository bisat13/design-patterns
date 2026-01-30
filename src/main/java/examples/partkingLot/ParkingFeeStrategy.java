package examples.partkingLot;

public class ParkingFeeStrategy implements ParkingFee{

  ParkingFee parkingFee;

  public ParkingFeeStrategy(ParkingFee parkingFee) {
    this.parkingFee = parkingFee;
  }

  public void setParkingFee(ParkingFee parkingFee) {
    this.parkingFee = parkingFee;
  }

  @Override
  public int calculateFee(int hours) {
    return parkingFee.calculateFee(hours);
  }
}
