package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.CheckBoxPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckboxTest extends TestBase{
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
	  super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
	  super.afterTest();
  }

}
