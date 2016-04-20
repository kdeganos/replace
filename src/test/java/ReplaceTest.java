import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

public class ReplaceTest {

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
