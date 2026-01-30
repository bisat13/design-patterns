package patterns.creational.abstractFactory;

public class ToyotaInsurance implements Insurance {

  @Override
  public void getInsurance() {
    System.out.println("Getting Toyota car insurance");
  }
}