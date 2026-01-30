package examples.Atm;

public class AtmMachine {

  private State idleState;
  private State authState;
  private State selectOperationState;
  private State withdrawState;
  private State checkBalanceState;
  private State outOfCashState;

  private State currentState;
  private int cash;
  private int balance = 5000;

  public AtmMachine(int cash) {
    idleState = new IdleState(this);
    authState = new AuthenticationState(this);
    selectOperationState = new SelectOperationState(this);
    withdrawState = new WithdrawState(this);
    checkBalanceState = new CheckBalanceState(this);
    outOfCashState = new OutOfCashState(this);

    this.cash = cash;
    currentState = cash > 0 ? idleState : outOfCashState;
  }

  public void insertCard() { currentState.insertCard(); }
  public void enterPin(int pin) { currentState.enterPin(pin); }
  public void selectOperation(String operation) { currentState.selectOperation(operation); }
  public void enterAmount(int amt) { currentState.enterAmount(amt); }
  public void ejectCard() { currentState.ejectCard(); }

  public void withdrawCash(int amount) {
    if (amount <= cash && amount <= balance) {
      cash -= amount;
      balance -= amount;
      System.out.println("Cash withdrawn: " + amount);

      if (cash<= 0) {
        setState(outOfCashState);
      }

    } else {
      System.out.println("Insufficient funds");
    }
  }

  public int getBalance() { return balance; }

  public void setState(State state) { this.currentState = state; }
  public State getIdleState() { return idleState; }
  public State getAuthState() { return authState; }
  public State getSelectOperationState() { return selectOperationState; }
  public State getWithdrawState() { return withdrawState; }
  public State getCheckBalanceState() { return checkBalanceState; }
  public State getOutOfCashState() { return outOfCashState; }
}
