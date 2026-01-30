package patterns.behavioral.command;

public class FanStartCommand implements Command {
  private Fan fan;

  public FanStartCommand(Fan fan) {
    this.fan = fan;
  }

  public void execute() {
    fan.start();
  }

  public void undo() {
    fan.stop();
  }
}
