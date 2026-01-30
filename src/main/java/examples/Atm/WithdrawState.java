package examples.Atm;

public class WithdrawState implements State {

  private AtmMachine atm;

  public WithdrawState(AtmMachine atm) {
    this.atm = atm;
  }

  public void insertCard() { }

  public void enterPin(int pin) { }

  public void selectOperation(String operation) { }

  public void enterAmount(int amount) {
    atm.withdrawCash(amount);
    atm.ejectCard();
  }

  public void ejectCard() {
    System.out.println("Transaction complete. Card ejected");
    atm.setState(atm.getIdleState());
  }
}
