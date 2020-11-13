package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.InfiniteScrollPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class InfiniteScrollTest extends TestBase{
  @Test
  public void doesPageLengthIncreaseOnScroll() {
	  //Arrange
	  int initialPageLength;
	  int finalPageLength;
	  //Act
	  InfiniteScrollPage scrollPage = new InfiniteScrollPage(driver,baseURL);
	  initialPageLength = scrollPage
			  .navigate()
			  .waitForElements()
			  .getJScrollCount();
	  
	  finalPageLength = scrollPage.scroll()
			  .waitForElements()
			  .getJScrollCount();
	  
	  //Assert
	  Assert.assertNotEquals(finalPageLength,initialPageLength);
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
