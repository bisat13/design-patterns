package patterns.behavioral.state;

public class OutOfStockState implements State {
  @Override
  public void insertCoin() {
    System.out.println("Machine out of stock");
  }

  @Override
  public void selectItem() {
    System.out.println("Machine out of stock");
  }

  @Override
  public void dispense() {
    System.out.println("Machine out of stock");
  }
}

