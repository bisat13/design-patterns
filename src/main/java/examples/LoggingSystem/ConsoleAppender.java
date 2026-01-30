package examples.LoggingSystem;

public class ConsoleAppender implements LogAppender{

  @Override
  public void append(String formattedMessage) {
    System.out.println(formattedMessage);
  }
}
