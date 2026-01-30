package examples.LoggingSystem;

import java.util.List;

public class ExampleUsage {

  public static void main(String[] args) {
    LogManager.initialize(LogLevel.DEBUG, List.of(new ConsoleAppender()), new SimpleLogFormatter());
    Logger logger = LogManager.getLogger();

    logger.info("This is info log");
    logger.debug("This is debug log");
    logger.error("This is error log");
  }
}
