package patterns.behavioral.iterator;

public class SimplePlaylistIterator implements PlaylistIterator {
  private Playlist playlist;
  public int index;
  public SimplePlaylistIterator(Playlist playlist) {
    this.playlist = playlist;
    this.index = 0;
  }
  @Override
  public boolean hasNext() {
    return index<playlist.getSongs().size();
  }

  @Override
  public String next() {
    return playlist.getSongs().get(index++);
  }
}
