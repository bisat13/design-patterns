package patterns.creational.abstractFactory;

public class BMWFactory implements VehicleFactory{

  @Override
  public Vehicle createVehicle() {
    return new BMW();
  }

  @Override
  public Insurance createInsurance() {
    return new BMWInsurance();
  }
}
