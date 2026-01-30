package examples.Atm;

public class Main {
  public static void main(String[] args) {

    AtmMachine atm = new AtmMachine(10000);

    atm.insertCard();atm.enterPin(1234);atm.selectOperation("withdraw");
    atm.enterAmount(1000);


    System.out.println("---------------------------------------------------");

    atm.insertCard();atm.enterPin(1234);atm.selectOperation("balance");
    atm.enterAmount(0);
  }
}
