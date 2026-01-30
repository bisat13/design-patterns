package examples.Atm;

public class SelectOperationState implements State {

  private AtmMachine atm;

  public SelectOperationState(AtmMachine atm) {
    this.atm = atm;
  }

  public void insertCard() {
    System.out.println("Card already inserted");
  }

  public void enterPin(int pin) {
    System.out.println("PIN already verified");
  }

  public void selectOperation(String operation) {
    if ("withdraw".equalsIgnoreCase(operation)) {
      atm.setState(atm.getWithdrawState());
    } else if ("balance".equalsIgnoreCase(operation)) {
      atm.setState(atm.getCheckBalanceState());
    } else {
      System.out.println("Invalid operation");
    }
  }

  public void enterAmount(int amount) {
    System.out.println("Select operation first");
  }

  public void ejectCard() {
    System.out.println("Card ejected");
    atm.setState(atm.getIdleState());
  }
}
