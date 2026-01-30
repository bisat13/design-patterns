package patterns.structural.facade;

public class FacadePatternDemo {

  public static void main(String[] args) {
    DVDPlayer dvd = new DVDPlayer();
    Projector projector = new Projector();
    SoundSystem soundSystem = new SoundSystem();

    HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(dvd, projector, soundSystem);

    homeTheaterFacade.watchMovie();
    homeTheaterFacade.endMovie();
  }
}
