package TheInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import TheInternet.controls.Table;
import TheInternet.foundation.PageObjectBase;

public class TablesPage extends PageObjectBase{

	public TablesPage(WebDriver driver, String url) {
		super(driver, url);
	}
	@FindBy(how=How.ID,using="table1")
	WebElement table1Element;
	
	public TablesPage navigate() {
		super.navigate("/tables");
		return this;
	}

	public String getAmountDueForUserTableRow1(String userEmailAddress) {
		String text = new Table(table1Element)
				.getRow(1)
				.getCell("Due")
				.getText();
		return text;
	}
	

}
