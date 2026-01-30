package patterns.creational.abstractFactory;

public class ToyotaFactory implements VehicleFactory{

  @Override
  public Vehicle createVehicle() {
    return new Toyota();
  }

  @Override
  public Insurance createInsurance() {
    return new ToyotaInsurance();
  }
}
