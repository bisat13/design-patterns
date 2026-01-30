package patterns.behavioral.state;

public class VendingMachineDemo {
  public static void main(String[] args) {
    VendingMachine machine = new VendingMachine(2);

    machine.insertCoin();
    machine.selectItem();
    machine.dispense();

    machine.insertCoin();
    machine.selectItem();
    machine.dispense();

    machine.insertCoin(); // Out of stock
  }
}

