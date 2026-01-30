package patterns.behavioral.state;

public class SoldState implements State {
  private VendingMachine machine;

  public SoldState(VendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Please wait, dispensing item");
  }

  @Override
  public void selectItem() {
    System.out.println("Item already selected");
  }

  @Override
  public void dispense() {
    machine.releaseItem();
    if (machine.getItemCount() > 0) {
      machine.setState(machine.getNoCoinState());
    } else {
      machine.setState(machine.getOutOfStockState());
    }
  }
}
