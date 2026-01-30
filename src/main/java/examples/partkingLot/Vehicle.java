package examples.partkingLot;

public abstract class Vehicle {
  private String licensePlate;
  private String vehicleType;
  private ParkingFee parkingFee;


  public Vehicle(String vehicleType, String licensePlate, ParkingFee parkingFee) {
    this.licensePlate = licensePlate;
    this.vehicleType = vehicleType;
    this.parkingFee = parkingFee;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public int calculateParkingFee(int hours) {
    return parkingFee.calculateFee(hours);
  }
}
