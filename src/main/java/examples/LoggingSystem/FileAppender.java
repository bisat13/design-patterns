package examples.LoggingSystem;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
  private final String filePath;

  public FileAppender(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public void append(String formattedMessage) {
    try(FileWriter fileWriter = new FileWriter(filePath, true)) {
      fileWriter.write(formattedMessage + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
