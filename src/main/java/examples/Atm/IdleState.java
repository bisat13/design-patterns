package examples.Atm;

public class IdleState implements State {

  private AtmMachine atm;

  public IdleState(AtmMachine atm) {
    this.atm = atm;
  }

  public void insertCard() {
    System.out.println("Card inserted");
    atm.setState(atm.getAuthState());
  }

  public void enterPin(int pin) {
    System.out.println("Insert card first");
  }

  public void selectOperation(String operation) {
    System.out.println("Insert card first");
  }

  public void enterAmount(int amount) {
    System.out.println("Insert card first");
  }

  public void ejectCard() {
    System.out.println("No card to eject");
  }
}
