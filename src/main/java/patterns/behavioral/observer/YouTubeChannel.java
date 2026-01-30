package patterns.behavioral.observer;

public interface YouTubeChannel {
  void addSubscriber(Subscriber subscriber);
  void removeSubscriber(Subscriber subscriber);
  void notifySubscriber();
}
