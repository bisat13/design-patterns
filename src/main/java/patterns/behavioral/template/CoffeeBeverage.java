package patterns.behavioral.template;

public class CoffeeBeverage extends Beverage {

  @Override
  void brew() {
    System.out.println("Brewing coffee...");
  }

  @Override
  void addCondiments() {
    System.out.println("Adding sugar and milk...");
  }

  @Override
  boolean customerWantsCondiments() {
    return false;
  }
}
