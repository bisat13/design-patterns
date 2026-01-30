package patterns.behavioral.command;

import java.util.List;

public class MacroCommand implements Command {

  private List<Command> commands;

  public MacroCommand(List<Command> commands) {
    this.commands = commands;
  }

  @Override
  public void execute() {
    for (Command command : commands) {
      command.execute();
    }
  }

  @Override
  public void undo() {
    for (int i = commands.size() - 1; i >= 0; i--) {
      commands.get(i).undo();
    }
  }
}

//MacroCommand is a composite command that executes multiple commands and undoes them in reverse order