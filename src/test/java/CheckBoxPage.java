

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends PageObjectBase{

	public CheckBoxPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public CheckBoxPage navigate() {
		super.navigate("/checkboxes");
		return this;
	}

	//driver.findElement(By.id("idOfTheElement")).click();
	public CheckBoxPage setCheckBox() {
		WebElement checkBoxElement = driver.findElement(By.xpath("//*[@id='checkboxes']/input"));
		CheckBox checkBoxWrapped = new CheckBox(checkBoxElement);
		checkBoxWrapped.setBox();
		return this;
	}

	public Boolean getCheckBox() {
		WebElement checkBoxElement = driver.findElement(By.xpath("//*[@id='checkboxes']/input"));
		CheckBox checkBoxWrapped = new CheckBox(checkBoxElement);
		return checkBoxWrapped.getBox();
	}

}
