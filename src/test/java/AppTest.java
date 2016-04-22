import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
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
    assertThat(pageSource().contains("Create and solve word puzzles"));
  }

  @Test 
  public void puzzleSubmitTest() {
    goTo("http://localhost:4567/");
    fill("#phrase").with("this is a test phrase");
    submit("#phrase-button");
    assertThat(pageSource().contains("th-s -s - t-st phr-s-"));
  }

} 