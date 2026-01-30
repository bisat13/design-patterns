package patterns.behavioral.state;

public class VendingMachine {
  private State noCoinState;
  private State hasCoinState;
  private State soldState;
  private State outOfStockState;

  private State currentState;
  private int itemCount;

  public VendingMachine(int itemCount) {
    this.itemCount = itemCount;

    noCoinState = new NoCoinState(this);
    hasCoinState = new HasCoinState(this);
    soldState = new SoldState(this);
    outOfStockState = new OutOfStockState();

    currentState = itemCount > 0 ? noCoinState : outOfStockState;
  }

  public void insertCoin() {
    currentState.insertCoin();
  }

  public void selectItem() {
    currentState.selectItem();
  }

  public void dispense() {
    currentState.dispense();
  }

  void setState(State state) {
    this.currentState = state;
  }

  void releaseItem() {
    System.out.println("Item dispensed");
    itemCount--;
  }

  // Getters
  public int getItemCount() {
    return itemCount;
  }

  public State getNoCoinState() {
    return noCoinState;
  }

  public State getHasCoinState() {
    return hasCoinState;
  }

  public State getSoldState() {
    return soldState;
  }

  public State getOutOfStockState() {
    return outOfStockState;
  }
}
