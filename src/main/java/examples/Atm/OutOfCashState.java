package examples.Atm;

public class OutOfCashState implements State {

  private AtmMachine atm;

  public OutOfCashState(AtmMachine atm) {
    this.atm = atm;
  }

  public void insertCard() {
    System.out.println("ATM out of cash");
  }

  public void enterPin(int pin) {
  }

  public void selectOperation(String operation) {
  }

  public void enterAmount(int amount) {
  }

  public void ejectCard() {
  }
}
