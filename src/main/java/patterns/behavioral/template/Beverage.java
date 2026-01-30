package patterns.behavioral.template;

public abstract class Beverage {

  final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    if (customerWantsCondiments()) {
      addCondiments();
    }
  }

  void boilWater() {
    System.out.println("Boiling water...");
  }

  void pourInCup() {
    System.out.println("Pouring into cup...");
  }

  // Steps to be customized by subclasses
  abstract void brew();

  abstract void addCondiments();

  // Hook method with default behavior
  boolean customerWantsCondiments() {
    return true;
  }
}
