package examples.Atm;

public class AuthenticationState implements State {

  private AtmMachine atm;

  public AuthenticationState(AtmMachine atm) {
    this.atm = atm;
  }

  public void insertCard() {
    System.out.println("Card already inserted");
  }

  public void enterPin(int pin) {
    if (pin == 1234) {
      System.out.println("PIN verified");
      atm.setState(atm.getSelectOperationState());
    } else {
      System.out.println("Invalid PIN");
      atm.ejectCard();
    }
  }

  public void selectOperation(String operation) {
    System.out.println("Enter PIN first");
  }

  public void enterAmount(int amount) {
    System.out.println("Enter PIN first");
  }

  public void ejectCard() {
    System.out.println("Card ejected");
    atm.setState(atm.getIdleState());
  }
}
