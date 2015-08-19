import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Music Collection");
  }

  @Test
  public void addArtist(){
    goTo("http://localhost:4567/");
    fill("#name").with("Prince");
    submit(".btn");
    assertThat(pageSource()).contains("Prince");
  }

  @Test
  public void addMultipleArtists(){
    goTo("http://localhost:4567/");
    fill("#name").with("Prince");
    submit(".btn");
    fill("#name").with("Jewel");
    submit(".btn");
    assertThat(pageSource()).contains("Prince");
    assertThat(pageSource()).contains("Jewel");
  }

  @Test
  public void selectArtistPage(){
    goTo("http://localhost:4567/");
    fill("#name").with("Prince");
    submit(".btn");
    assertThat(pageSource()).contains("Prince");
    click("a", withText("Prince"));
    assertThat(pageSource()).contains("Prince");
  }
}
