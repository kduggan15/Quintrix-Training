package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.InputPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class InputTest extends TestBase{
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
  @BeforeTest
  public void beforeTest() {
	  super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
	  super.afterTest();
  }

}
