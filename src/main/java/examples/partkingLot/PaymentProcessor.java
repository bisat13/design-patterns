package examples.partkingLot;

public class PaymentProcessor implements Payment{
  private Payment payment;
  public PaymentProcessor(Payment payment) {
    this.payment = payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }
  @Override
  public void processPayment(double amount) {
    if (amount > 0 ){
      payment.processPayment(amount);
    } else {
      System.out.println("Invalid payment amount");
    }
  }
}
