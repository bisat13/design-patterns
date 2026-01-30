package patterns.behavioral.state;

public class NoCoinState implements State {
  private VendingMachine machine;

  public NoCoinState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Coin inserted");
    machine.setState(machine.getHasCoinState());
  }

  @Override
  public void selectItem() {
    System.out.println("Insert coin first");
  }

  @Override
  public void dispense() {
    System.out.println("Payment required");
  }
}
