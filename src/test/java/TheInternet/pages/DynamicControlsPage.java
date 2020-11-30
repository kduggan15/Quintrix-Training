package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TheInternet.foundation.PageObjectBase;

public class DynamicControlsPage extends PageObjectBase{

	public DynamicControlsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public DynamicControlsPage navigate() {
		super.navigate("/dynamic_controls");
		return this;
	}

	public DynamicControlsPage removeCheckbox() {
		WebElement removeButton = driver.findElement(By.cssSelector("#checkbox-example button"));
		removeButton.click();
		return this;
	}
	
	public DynamicControlsPage waitForNoCheckBox() {
		while(isCheckboxPresent()){
			
		}
		return this;
	}

	public boolean isCheckboxPresent() {
		try {
			driver.findElement(By.cssSelector("#checkbox"));
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	

}
