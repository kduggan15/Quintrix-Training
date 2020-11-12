package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.DisappearingElementsPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DisappearingElementsTest extends TestBase{
  @Test
  public void doesEachElementHaveURL() {
	  Boolean hasLink = new DisappearingElementsPage(driver,baseURL)
			  .navigate()
			  .eachHasLink();
	  Assert.assertTrue(hasLink);
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
