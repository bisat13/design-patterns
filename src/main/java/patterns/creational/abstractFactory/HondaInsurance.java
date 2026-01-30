package patterns.creational.abstractFactory;

public class HondaInsurance implements Insurance {

  @Override
  public void getInsurance() {
    System.out.println("Getting Honda car insurance");
  }
}
