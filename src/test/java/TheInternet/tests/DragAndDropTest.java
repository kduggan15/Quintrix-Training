package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.DragAndDropPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DragAndDropTest extends TestBase{
  @Test
  public void verifiesDragAndDrop() {
	  //Arrange
	  String expectedFirst = "A";
	  //Act
	  String actualFirst = new DragAndDropPage(driver, baseURL)
			  .navigate()
			  .swap()
			  .firstCol();
	  //Assert
	  Assert.assertEquals(actualFirst, expectedFirst);
			  
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
