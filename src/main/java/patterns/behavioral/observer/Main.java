package patterns.behavioral.observer;

public class Main {

  public static void main(String[] args) {
    YouTubeChannelImpl channel = new YouTubeChannelImpl();
    Subscriber a = new EmailSubscriber("alice");
    Subscriber b = new YouTubeSubscriber("bob");

    channel.addSubscriber(a);
    channel.addSubscriber(b);

    channel.uploadNewVideo("Design Patterns");

    channel.removeSubscriber(b);
    channel.uploadNewVideo("Graphs");
  }
}
