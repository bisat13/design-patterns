package patterns.creational.abstractFactory;

public class Main {

  public static void main(String[] args) {
    VehicleFactory hondaFactory = new HondaFactory();
    Vehicle honda = hondaFactory.createVehicle();
    honda.start();
    honda.stop();
    Insurance hondaInsurance = hondaFactory.createInsurance();
    hondaInsurance.getInsurance();

    VehicleFactory toyotaFactory = new ToyotaFactory();
    Vehicle toyota = toyotaFactory.createVehicle();
    toyota.start();
    toyota.stop();
    Insurance toyotaInsurance = toyotaFactory.createInsurance();
    toyotaInsurance.getInsurance();
  }
}
