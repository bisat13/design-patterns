package patterns.behavioral.command;

import java.util.Arrays;

//Client
//Client → Invoker → Command → Receiver
public class Client {

  public static void main(String[] args) {
    Light livingRommLight = new Light();
    Fan fan = new Fan();

    Command fanStart = new FanStartCommand(fan);
    Command fanStop = new FanStopCommand(fan);

    Command lightOn = new LightOnCommand(livingRommLight);
    Command lightOff = new LightOffCommand(livingRommLight);

    Command partyMode = new MacroCommand(Arrays.asList(lightOn, fanStart));

    RemoteControl remote = new RemoteControl();

    remote.setCommand(lightOn);
    remote.pressButton();
    remote.setCommand(lightOff);
    remote.pressButton();

    remote.pressUndo();
    remote.pressUndo();

    remote.setCommand(partyMode);
    remote.pressButton();
    remote.pressUndo();
  }
}
