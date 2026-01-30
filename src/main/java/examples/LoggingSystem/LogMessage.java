package examples.LoggingSystem;

import java.time.LocalDateTime;

public class LogMessage {
private final LogLevel logLevel;
private final String message;
private final LocalDateTime timestamp;
private final String threadName;

  public LogMessage(LogLevel logLevel, String message) {
    this.logLevel = logLevel;
    this.message = message;
    this.timestamp = LocalDateTime.now();
    this.threadName = Thread.currentThread().getName();
  }

  public LogLevel getLevel() {
    return logLevel;
  }

  public String getMessage() {
    return message;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public String getThreadName() {
    return threadName;
  }
}
