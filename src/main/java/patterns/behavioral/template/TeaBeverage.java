package patterns.behavioral.template;

public class TeaBeverage extends Beverage{

  @Override
  void brew() {
    System.out.println("Steeping tea bag...");
  }
  @Override
  void addCondiments() {
    System.out.println("Adding lemon...");
  }
}
