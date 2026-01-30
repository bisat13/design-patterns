package patterns.behavioral.state;

public class HasCoinState implements State {
  private VendingMachine machine;

  public HasCoinState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Coin already inserted");
  }

  @Override
  public void selectItem() {
    System.out.println("Item selected");
    machine.setState(machine.getSoldState());
  }

  @Override
  public void dispense() {
    System.out.println("Select item first");
  }
}
