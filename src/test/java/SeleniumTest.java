import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SeleniumTest {
  @Test
  public void canLaunchWebDriver() {
	  //Arrange
	  WebDriver driver = new ChromeDriver();
	  String url = "https://www.google.com/";
	  
	  //Act
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();
	  
	  //Assert
	  Assert.assertEquals(currentURL, url);
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
