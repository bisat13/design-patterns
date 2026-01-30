package patterns.behavioral.observer;

public class YouTubeSubscriber implements Subscriber{
  String name;
  public YouTubeSubscriber(String name){
    this.name = name;
  }
  @Override
  public void update(String video) {
    System.out.println(name + " is watching the video: " + video);
  }
}
