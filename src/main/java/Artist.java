import java.util.ArrayList;

public class Artist {
  private static ArrayList<Artist> playlist = new ArrayList<Artist>();
  private String mName;
  private int mId;

  public Artist(String name) {
    mName = name;
    playlist.add(this);
    mId = playlist.size();
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Artist> all() {
    return playlist;
  }

  public int getId() {
    return mId;
  }

  public static Artist find(int id) {
    try {
      return playlist.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

}
