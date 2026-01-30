package patterns.creational.abstractFactory;

public class BMWInsurance implements Insurance{

  @Override
  public void getInsurance() {
    System.out.println("Getting BMW car insurance");
  }
}
