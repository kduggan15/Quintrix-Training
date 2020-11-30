package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import TheInternet.foundation.PageObjectBase;

public class ContextMenuPage extends PageObjectBase{

	public ContextMenuPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public ContextMenuPage navigate() {
		super.navigate("/context_menu");
		return this;
	}

	public ContextMenuPage clickContext() {
		Actions action = new Actions(driver);
		WebElement contextButton = driver.findElement(By.cssSelector("#hot-spot"));
		action.contextClick(contextButton).perform();
		return this;
	}

	public Boolean isAlert() {
		try {
			driver.switchTo().alert();
		}catch (NoAlertPresentException e) {
			return false;
		}
		return true;
	}
	
	

}
