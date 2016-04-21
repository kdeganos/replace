import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ReplaceTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Type in a phrase here.");
  }

  @Test
  public void findAndReplace_replaceHelloWithGoodbye_goodbyeWorld() {
    Replace testReplace = new Replace();
    String expected = "goodbye world";
    assertEquals(expected, testReplace.findAndReplace("hello world", "hello", "goodbye"));
  }

  @Test
  public void findAndReplace_replaceHelloWithGoodbyeCaseInsensitive_goodbyeWorld() {
    Replace testReplace = new Replace();
    String expected = "goodbye world";
    assertEquals(expected, testReplace.findAndReplace("Hello world", "hello", "goodbye"));
  }

    @Test
    public void findAndReplace_replaceCatwithDog_Doghedral() {
      Replace testReplace = new Replace();
      String expected = "I am walking my dog to the doghedral";
      assertEquals(expected, testReplace.findAndReplace("I am walking my cat to the cathedral", "cat", "dog"));

    }
}
