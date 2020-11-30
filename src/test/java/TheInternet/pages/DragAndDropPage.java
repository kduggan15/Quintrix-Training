package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import TheInternet.foundation.PageObjectBase;

public class DragAndDropPage extends PageObjectBase{

	public DragAndDropPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public DragAndDropPage navigate() {
		super.navigate("/drag_and_drop");
		return this;
	}

	public DragAndDropPage swap() {
		WebElement dndElement = driver.findElement(By.cssSelector("#columns"));
		WebElement colA = dndElement.findElement(By.cssSelector("#column-a"));
		WebElement colB = dndElement.findElement(By.cssSelector("#column-b"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(colA,colB).build().perform();
		
		return this;
	}

	public String firstCol() {
		WebElement dndElement = driver.findElement(By.cssSelector("#columns"));
		//WebElement colA = dndElement.findElement(By.cssSelector("column-a"));
		return dndElement.findElement(By.cssSelector("#column-a header")).getText();
	}

}
