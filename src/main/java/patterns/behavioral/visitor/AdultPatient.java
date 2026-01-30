package patterns.behavioral.visitor;

public class AdultPatient implements Patient{

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
