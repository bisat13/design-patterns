package patterns.behavioral.visitor;

public interface Patient {
  void accept(Visitor visitor);
}
