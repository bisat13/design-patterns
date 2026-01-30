package patterns.behavioral.observer;

import java.util.*;

public class YouTubeChannelImpl implements YouTubeChannel{
  List<Subscriber> subscribers = new ArrayList<>();
  String video;
  @Override
  public void addSubscriber(Subscriber subscriber) {
    subscribers.add(subscriber);
  }

  @Override
  public void removeSubscriber(Subscriber subscriber) {
    subscribers.remove(subscriber);
  }

  @Override
  public void notifySubscriber() {
    for (Subscriber subscriber: subscribers) {
      subscriber.update(video);
    }
  }

  public void uploadNewVideo(String video) {
    this.video = video;
    notifySubscriber();
  }

}
