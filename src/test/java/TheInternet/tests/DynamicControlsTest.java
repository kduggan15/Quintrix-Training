package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.DynamicControlsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicControlsTest extends TestBase{
  @Test
  public void verfiesCheckboxLoads() {
	  //Arrange
	  //Act
	  boolean isCheckboxPresent = new DynamicControlsPage(driver, baseURL)
			  .navigate()
			  .removeCheckbox()
			  .waitForNoCheckBox()
			  .isCheckboxPresent();
	  //Assert
	  Assert.assertFalse(isCheckboxPresent);
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
