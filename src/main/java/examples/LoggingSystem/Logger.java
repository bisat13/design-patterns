package examples.LoggingSystem;

import java.util.List;

public class Logger {

  private final LogLevel miniLogLevel;
  private final List<LogAppender> appenders;
  private final LogFormatter logFormatter;

  public Logger(LogLevel miniLogLevel, List<LogAppender> appenders, LogFormatter logFormatter) {
    this.miniLogLevel = miniLogLevel;
    this.appenders = appenders;
    this.logFormatter = logFormatter;
  }

  public void log(LogLevel logLevel, String message) {
    if (logLevel.getPriority() < miniLogLevel.getPriority()) {
      return;
    }
    LogMessage logMessage = new LogMessage(logLevel, message);
    String formattedMessage = logFormatter.format(logMessage);

    for (LogAppender logAppender : appenders) {
      logAppender.append(formattedMessage);
    }
  }

  public void debug(String msg) { log(LogLevel.DEBUG, msg); }
  public void info(String msg) { log(LogLevel.INFO, msg); }
  public void warn(String msg) { log(LogLevel.WARN, msg); }
  public void error(String msg) { log(LogLevel.ERROR, msg); }
}
