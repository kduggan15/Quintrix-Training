package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.DynamicLoadingPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DynamicLoadingTest extends TestBase{
  @Test
  public void verfiesDynamicallyLoadedHidden() {
	  //Arrange
	  //Act
	  boolean isPresent = new DynamicLoadingPage(driver,baseURL)
			  .navigate()
			  .pressStart()
			  .waitForResource()
			  .isResourceUnhidden();
	  //Assert
	  Assert.assertTrue(isPresent);
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
