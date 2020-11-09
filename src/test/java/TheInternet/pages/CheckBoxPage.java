package TheInternet.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import TheInternet.foundation.PageObjectBase;
import TheInternet.controls.CheckBox;

public class CheckBoxPage extends PageObjectBase{

	public CheckBoxPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public CheckBoxPage navigate() {
		super.navigate("/checkboxes");
		return this;
	}

	//driver.findElement(By.id("idOfTheElement")).click();
	public CheckBoxPage setCheckboxes() {
		ArrayList<WebElement> checkBoxElements = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='checkboxes']/input"));
		for(WebElement element : checkBoxElements) {
			CheckBox checkBoxWrapped = new CheckBox(element);
			checkBoxWrapped.setBox();
		}
		
		return this;
	}

	public Boolean areCheckboxesSet() {
		ArrayList<WebElement> checkBoxElements = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='checkboxes']/input"));
		boolean allChecked = true;
		for(WebElement element : checkBoxElements) {
			CheckBox checkBoxWrapped = new CheckBox(element);
			allChecked&=checkBoxWrapped.getBox();
		}
		return allChecked;
	}

}
