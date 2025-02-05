package TheInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import TheInternet.foundation.PageObjectBase;

public class DropdownPage extends PageObjectBase {

	public DropdownPage(WebDriver driver, String url) {
		super(driver,url);
	}
	
	@FindBy(id="dropdown")
	WebElement dropDownList;

	public DropdownPage navigate() {
		super.navigate("/dropdown");
		return this;
	}

	public DropdownPage select(String option) {
		new Select(dropDownList).selectByVisibleText(option);
		return this;
	}

	public String getOption() {
		return new Select(dropDownList).getFirstSelectedOption().getText();
	}

}
