package TheInternet.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SeleniumTest {
  private WebDriver driver;
  @Test
  public void canLaunchWebDriver() {
	  //Arrange
	  String url = "https://www.google.com/";
	  
	  //Act
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();
	  
	  //Assert
	  Assert.assertEquals(currentURL, url);
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
