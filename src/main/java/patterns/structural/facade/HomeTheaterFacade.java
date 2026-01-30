package patterns.structural.facade;

public class HomeTheaterFacade {

  private DVDPlayer dvd;
  private Projector projector;
  private SoundSystem soundSystem;

  public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem soundSystem) {
    this.dvd = dvd;
    this.projector = projector;
    this.soundSystem = soundSystem;
  }

  public void watchMovie() {
    System.out.println("Get ready to watch a movie...");
    projector.on();
    soundSystem.on();
    soundSystem.setVolume(10);
    dvd.on();
    dvd.play();
  }

  public void endMovie() {
    System.out.println("Shutting down movie theater...");
    dvd.off();
    soundSystem.off();
    projector.off();
  }
}
