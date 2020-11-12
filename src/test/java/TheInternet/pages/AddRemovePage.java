package TheInternet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TheInternet.foundation.PageObjectBase;

public class AddRemovePage extends PageObjectBase{

	public AddRemovePage(WebDriver driver, String url) {
		super(driver, url);
	}

	public AddRemovePage navigate() {
		super.navigate("/add_remove_elements/");
		return this;
	}

	public AddRemovePage addElement() {
		WebElement addButton = driver.findElement(By.cssSelector(".example button"));
		addButton.click();
		return this;
	}

	public Boolean elementExists() {
		List<WebElement> buttons = driver.findElements(By.xpath("//*[@id='elements']/button"));
		return buttons.size()>=1;
	}

	public AddRemovePage removeElement() {
		if (elementExists()) {
			WebElement removeButton = driver.findElement(By.xpath("//*[@id='elements']/button"));
			removeButton.click();
		}
		return this;
	}

}
