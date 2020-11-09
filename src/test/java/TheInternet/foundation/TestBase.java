package TheInternet.foundation;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


public class TestBase {
  protected WebDriver driver;
  protected String baseURL;
  
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
