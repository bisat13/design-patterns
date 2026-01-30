package examples.partkingLot;

public abstract class ParkingSpot {

  int spotNumber;
  boolean isOccupied;
  Vehicle vehicle;
  String spotType;

  public ParkingSpot(int slotNumber, String spotType) {
    this.spotNumber = slotNumber;
    this.isOccupied = false;
    this.spotType = spotType;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public abstract boolean canParkVehicle(Vehicle vehicle);

  public void parkVehicle(Vehicle vehicle) {
    if (isOccupied) {
      throw new IllegalStateException("Spot is already occupied.");
    }
    if (!canParkVehicle(vehicle)) {
      throw new IllegalArgumentException(
          "This spot is not suitable for" + vehicle.getVehicleType());
    }
    this.vehicle = vehicle;
    this.isOccupied = true;
  }

  public void vacate() {
    if (!isOccupied) {
      throw new IllegalStateException("Spot is already vacant.");
    }
    this.vehicle = null;
    this.isOccupied = false;
  }

  public int getSpotNumber() {
    return spotNumber;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public String getSpotType() {
    return spotType;
  }
}
