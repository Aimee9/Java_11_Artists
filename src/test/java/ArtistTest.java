import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void artist_instantiatesCorrectly_true() {
    Artist myArtist = new Artist("Prince");
    assertEquals(true, myArtist instanceof Artist);
  }

  @Test
  public void task_instantiatesWithName_true() {
    Artist myArtist = new Artist("Prince");
    assertEquals ("Prince", myArtist.getName());
  }

  @Test
  public void all_returnsAllPlayListOfArtist_true() {
    Artist firstArtist = new Artist("Prince");
    Artist secondArtist = new Artist("Queen");
    assertTrue(Artist.all().contains(firstArtist));
    assertTrue(Artist.all().contains(secondArtist));
  }

  @Test
  public void newId_artistInstantiateWithAnID_true() {
    Artist myArtist = new Artist("Prince");
    assertEquals(Artist.all().size(), myArtist.getId());
  }

  @Test
  public void find_returnsArtistWithSameId_secondArtist() {
    Artist firstArtist = new Artist("Prince");
    Artist secondArtist = new Artist("Queen");
    assertEquals(Artist.find(secondArtist.getId()), secondArtist);
  }

  @Test
  public void find_returnsNullWhenNoArtistFound_null() {
    assertTrue(Artist.find(999) == null);
  }

  // @Test
  // public void clear_selectedArtist(){
  //   Artist myArtist = new Artist("Prince");
  //   Artist.remove(1);
  //   assertEquals(Artist.all().size(), 0);
  // }

}
