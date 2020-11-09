package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.DropdownPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DropdownTest extends TestBase{
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
  @BeforeTest
  public void beforeTest() {
	  super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
	  super.afterTest();
  }

}
