package examples.LoggingSystem;

import java.util.List;

public class LogManager {

  private static volatile Logger logger;

  private LogManager() {
  }

  public static Logger getLogger() {
      if (logger == null) {
        synchronized (LogManager.class) {
          if (logger == null) {
            logger = defaultLogger();
          }
        }
      }
      return logger;
  }

  private static Logger defaultLogger() {
    return new Logger(LogLevel.DEBUG, List.of(new ConsoleAppender()), new SimpleLogFormatter());
  }

  public static void initialize(LogLevel level, List<LogAppender> appenders, LogFormatter formatter) {
    synchronized (LogManager.class) {
      if (logger == null) {
        logger = new Logger(level, appenders, formatter);
      }
    }
  }
}
