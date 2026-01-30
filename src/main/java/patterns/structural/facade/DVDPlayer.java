package patterns.structural.facade;

class DVDPlayer {
  void on() {
    System.out.println("DVD Player is ON");
  }

  void play() {
    System.out.println("DVD Player is playing");
  }

  void off() {
    System.out.println("DVD Player is OFF");
  }
}