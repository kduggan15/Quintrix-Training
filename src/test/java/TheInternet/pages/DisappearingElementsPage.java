package TheInternet.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TheInternet.foundation.PageObjectBase;

public class DisappearingElementsPage extends PageObjectBase{

	public DisappearingElementsPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public DisappearingElementsPage navigate() {
		super.navigate("/disappearing_elements");
		return this;
	}

	public Boolean eachHasLink() {
		ArrayList<WebElement> menuElements = (ArrayList<WebElement>) driver.findElements(By.cssSelector("ul li a"));
		
		for(WebElement element : menuElements) {
			if(element.getAttribute("href")== null) {
				return false;
			}
		}
		return true;
	}

}
