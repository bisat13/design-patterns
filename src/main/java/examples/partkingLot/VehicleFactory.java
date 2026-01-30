package examples.partkingLot;

public class VehicleFactory {
  public static Vehicle createVehicle(String vehicleType, String licensePlate, ParkingFee parkingFee) {
    if (vehicleType.equalsIgnoreCase("car")){
      return new Car(vehicleType, licensePlate, parkingFee);
    } else if (vehicleType.equalsIgnoreCase("bike")){
      return new Bike(vehicleType, licensePlate, parkingFee);
    } else {
      throw new RuntimeException("Vehicle type not accepted");
    }
  }
}
