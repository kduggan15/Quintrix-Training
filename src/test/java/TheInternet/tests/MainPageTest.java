package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.pages.IndexPage;
import TheInternet.foundation.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MainPageTest extends TestBase{
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
  @BeforeTest
  public void beforeTest() {
	  super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
	  super.afterTest();
  }

}
