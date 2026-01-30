package examples.Atm;

public class CheckBalanceState implements State {

  private AtmMachine atm;

  public CheckBalanceState(AtmMachine atm) {
    this.atm = atm;
  }

  public void insertCard() { }

  public void enterPin(int pin) { }

  public void selectOperation(String operation) { }

  public void enterAmount(int amount) {
    System.out.println("Current balance: " + atm.getBalance());
    atm.ejectCard();
  }

  public void ejectCard() {
    System.out.println("Card ejected");
    atm.setState(atm.getIdleState());
  }
}
