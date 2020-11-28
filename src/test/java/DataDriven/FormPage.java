package DataDriven;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DataDriven.framework.FormModelObject;
import TheInternet.controls.Input;
import TheInternet.foundation.PageObjectBase;
import TheInternet.pages.InputPage;

public class FormPage extends PageObjectBase{

	public FormPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public FormPage navigate() {
		driver
		.navigate()
		.to("https://demoqa.com/automation-practice-form");
		return this;
	}

	public FormPage fillForm(FormModelObject obj) {
		WebElement first = driver.findElement(By.cssSelector("#firstName"));
		WebElement last = driver.findElement(By.cssSelector("#lastName"));
		WebElement email = driver.findElement(By.cssSelector("#userEmail"));
		WebElement number = driver.findElement(By.cssSelector("#userNumber"));
		
		Input inputWrapped = new Input(first);
		inputWrapped.setText(obj.getFirstName());
		
		inputWrapped = new Input(last);
		inputWrapped.setText(obj.getLastName());
		
		inputWrapped = new Input(email);
		inputWrapped.setText(obj.getEmail());
		
		inputWrapped = new Input(number);
		inputWrapped.setText(obj.getPhoneNumber());
		
		selectGender(obj.getGender());
		
		
		return this;
	}

	private void selectGender(String gen) {
		WebElement gender = null;
		if (gen.equalsIgnoreCase("male") || gen.equalsIgnoreCase("m")) {
			gender = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		} else if(gen.equalsIgnoreCase("female") || gen.equalsIgnoreCase("f")) {
			gender = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		} else if(gen.equalsIgnoreCase("other")) {
			gender = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
		}
		gender.click();	
	}

	public FormPage submit() {
		WebElement button = driver.findElement(By.cssSelector("#submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
		//button.click();
		return this;
	}

	public FormModelObject getResults() {
		driver.switchTo().activeElement();
		List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
		String name = rows.get(0).findElements(By.cssSelector("td")).get(1).getText();
		String first = name.split(" ")[0];
		String last = name.split(" ")[1];
		
		String email = rows.get(1).findElements(By.cssSelector("td")).get(1).getText();
		String number = rows.get(3).findElements(By.cssSelector("td")).get(1).getText();
		
		return new FormModelObject(first, last, email, "other", number);
	}

}
