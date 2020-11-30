package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TheInternet.foundation.PageObjectBase;

public class LoginPage extends PageObjectBase{

	public LoginPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public LoginPage navigate() {
		super.navigate("/basic_auth");
		return this;
	}

	public LoginPage login() {
		driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		return this;
	}

	public Boolean isLoggedin() {
		WebElement heading =  driver.findElement(By.cssSelector("h3"));
		return heading.getText().contains("Basic Auth");
	}

}
