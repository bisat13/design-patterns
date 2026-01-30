package patterns.structural.decorator;

public class Main {

  public static void main(String[] args) {
    Coffee coffee = new Espresso();
    coffee = new MilkDecorator(coffee);
    coffee = new SugarDecorator(coffee);
    coffee = new VanillaDecorator(coffee);
    System.out.println("Order: " + coffee.getDescription());
    System.out.println("Total Cost: $" + coffee.getCost());
  }
}
