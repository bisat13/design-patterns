package patterns.behavioral.template;

public class BeverageTemplateDemo {

  public static void main(String[] args) {
    Beverage coffee = new CoffeeBeverage();
    Beverage tea = new TeaBeverage();
    System.out.println("Making coffee...");
    coffee.prepareRecipe();
    System.out.println("\nMaking tea...");
    tea.prepareRecipe();
  }
}
