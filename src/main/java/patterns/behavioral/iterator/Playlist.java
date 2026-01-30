package patterns.behavioral.iterator;

import java.util.ArrayList;

public class Playlist {
  private ArrayList<String> songs;
  public Playlist() {
    songs = new ArrayList<>();
  }

  public void addSong(String song){
    songs.add(song);
  }

  public ArrayList<String> getSongs(){
    return songs;
  }

  public PlaylistIterator iterator(String type) {
    switch (type) {
      case "simple" :
        return new SimplePlaylistIterator(this);
      case "shuffled":
        return new ShuffledPlaylistIterator(this);
      case "favorites":
        return new FavoritesPlaylistIterator(this);
      default:
        return null;
    }
  }
}
