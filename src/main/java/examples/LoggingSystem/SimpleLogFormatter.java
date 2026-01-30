package examples.LoggingSystem;

public class SimpleLogFormatter implements LogFormatter{

  @Override
  public String format(LogMessage logMessage) {
    return String.format(
        "[%s] [%s] [%s] %s",
        logMessage.getTimestamp(), logMessage.getThreadName(),
        logMessage.getLevel(), logMessage.getMessage());
  }
}
