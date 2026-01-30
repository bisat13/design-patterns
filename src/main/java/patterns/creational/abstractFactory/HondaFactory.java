package patterns.creational.abstractFactory;

public class HondaFactory implements VehicleFactory{

  @Override
  public Vehicle createVehicle() {
    return new Honda();
  }

  @Override
  public Insurance createInsurance() {
    return new HondaInsurance();
  }
}
