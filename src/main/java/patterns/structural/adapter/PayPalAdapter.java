package patterns.structural.adapter;

public class PayPalAdapter implements PaymentProcessor {

  PayPalService payPalService;

  public PayPalAdapter(PayPalService payPalService) {
    this.payPalService = payPalService;
  }

  @Override
  public void pay(double amount) {
    payPalService.makePayment(amount);
  }
}

//Adapter Pattern = Interface conversion, not behavior change
