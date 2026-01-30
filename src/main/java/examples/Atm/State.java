package examples.Atm;

public interface State {

  void insertCard();
  void enterPin(int pin);
  void selectOperation(String operation);
  void enterAmount(int amount);
  void ejectCard();
}

/*
IdleState
   ↓ insertCard
    AuthenticationState
   ↓ enterPin (success)
SelectOperationState
   ↓ choose withdraw / balance
CashWithdrawalState  OR  CheckBalanceState
   ↓ ejectCard
    IdleState
 */