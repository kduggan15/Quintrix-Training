package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.ContextMenuPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ContextMenuTest extends TestBase{
  @Test
  public void verifyRightClickAlert() {
	  Boolean didAlert = new ContextMenuPage(driver, baseURL)
			  .navigate()
			  .clickContext()
			  .isAlert();
	  Assert.assertTrue(didAlert);
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
