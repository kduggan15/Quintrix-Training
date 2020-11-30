package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.TablesPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SortableTableTest extends TestBase{
  @Test
  public void canGetTable1CellContents() {
	  //String userEmailAddress = "jdoe@hotmail.com";
	  String expectedText = "$50.00";
	  String actualText = new TablesPage(driver,baseURL)
			  .navigate()
			  .getAmountDueForUserTableRow1("Due");
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
