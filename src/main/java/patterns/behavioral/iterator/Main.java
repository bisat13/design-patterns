package patterns.behavioral.iterator;

public class Main {

  public static void main(String[] args) {
    Playlist playlist = new Playlist();
    playlist.addSong("Song 1");
    playlist.addSong("Song 2 Fav");
    playlist.addSong("Song 3");
    playlist.addSong("Song 4 Fav");
    playlist.addSong("Song 5");

    // Simple Playlist Iterator
    System.out.println("Simple Playlist:");
    PlaylistIterator simpleIterator = playlist.iterator("simple");
    while (simpleIterator.hasNext()) {
      System.out.println("Playing: " + simpleIterator.next());
    }

    // Shuffled Playlist Iterator
    System.out.println("Shuffled Playlist:");
    PlaylistIterator shuffledIterator = playlist.iterator("shuffled");
    while (shuffledIterator.hasNext()) {
      System.out.println("Playing: " + shuffledIterator.next());
    }

    // Favorites Playlist Iterator
    System.out.println("Favorites Playlist:");
    PlaylistIterator favoritesIterator = playlist.iterator("favorites");
    while (favoritesIterator.hasNext()) {
      System.out.println("Playing: " + favoritesIterator.next());
    }
  }

}
