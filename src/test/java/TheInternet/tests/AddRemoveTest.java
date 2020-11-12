package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.AddRemovePage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AddRemoveTest extends TestBase{
  @Test
  public void canAddRemoveElements() {
	  Boolean expectedValue = true;
	  Boolean actualValue = new AddRemovePage(driver, baseURL)
			  .navigate()
			  .addElement()
			  .elementExists();
	  Assert.assertEquals(actualValue, expectedValue);
	  
	  expectedValue = false;
	  actualValue = new AddRemovePage(driver, baseURL)
			  .navigate()
			  .addElement()
			  .removeElement()
			  .elementExists();
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
