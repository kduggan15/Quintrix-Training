package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TheInternet.foundation.PageObjectBase;

public class DynamicLoadingPage extends PageObjectBase{

	public DynamicLoadingPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public DynamicLoadingPage navigate() {
		super.navigate("/dynamic_loading/1");
		return this;
	}

	public DynamicLoadingPage pressStart() {
		driver.findElement(By.cssSelector("#start button")).click();
		return this;
	}

	public DynamicLoadingPage waitForResource() {
		while(!isResourceUnhidden()) {
			
		}
		return this;
	}

	public boolean isResourceUnhidden() {
		
		return driver.findElement(By.cssSelector("#finish")).isDisplayed();
	}

}
