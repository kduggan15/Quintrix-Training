import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TheInternet {
  private WebDriver driver;
  protected String baseURL;
  @Test
  public void canLaunchWebDriver() {
	  //Arrange
	  String url = "https://the-internet.herokuapp.com/";
	  String expectedTitle = "The Internet";
	  //Act
	  String actualTitle = new IndexPage(driver,url)
			  .navigate()
			  .getTitle();
	  
	  
	  //Assert
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test
  public void canSelectDropdownList() {
	  //Arrange
	  String url = "https://the-internet.herokuapp.com/";
	  String expectedSelection = "Option 2";
	  //Act
	  String actualSelection = new DropdownPage(driver,url)
			  .navigate()
			  .select(expectedSelection)
			  .getOption();
	  
	  
	  //Assert
	  Assert.assertEquals(actualSelection, expectedSelection);
  }
  @Test
  public void canInputText() {
	  //Arrange
	  String url = "https://the-internet.herokuapp.com/";
	  String expectedText = "123";
	  //Act
	  String actualText = new InputPage(driver,url)
			  .navigate()
			  .setInput(expectedText)
			  .getInput();
	  //Assert
	  Assert.assertEquals(actualText, expectedText);
			  
  }
  
  @Test
  public void canCheckBoxes() {
	  //Arrange
	  String url = "https://the-internet.herokuapp.com/";
	  Boolean expectedValue = true;
	  //Act
	  Boolean actualValue = new CheckBoxPage(driver, url)
			  .navigate()
			  .setCheckBox()
			  .getCheckBox();
	  Assert.assertEquals(actualValue, expectedValue);
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  HashMap<String,String> configs = null;
	  try {
		  configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
	  } catch (IOException e) {
		  //e.printStackTrace();
		  throw new RuntimeException(e+"Config file does not exist");
	  }
	  this.baseURL = configs.get("url");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
