package TheInternet.pages;

import org.openqa.selenium.WebDriver;

import TheInternet.foundation.PageObjectBase;

public class LoginPage extends PageObjectBase{

	public LoginPage(WebDriver driver, String url) {
		super(driver, url);
		// TODO Auto-generated constructor stub
	}
	
	public LoginPage navigate() {
		super.navigate("/checkboxes");
		return this;
	}

	public LoginPage login() {
		// TODO Auto-generated method stub
		return this;
	}

	public Boolean isLoggedin() {
		// TODO Auto-generated method stub
		return null;
	}

}
