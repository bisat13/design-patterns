package examples.LoggingSystem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AsyncAppender implements LogAppender {

  private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

  public AsyncAppender(LogAppender delegate) {
    Thread worker = new Thread(() -> {
      while (true) {
        try {
          delegate.append(queue.take());
        } catch (InterruptedException ignored) {}
      }
    });
    worker.setDaemon(true);
    worker.start();
  }

  @Override
  public void append(String formattedMessage) {
    queue.offer(formattedMessage);
  }
}

