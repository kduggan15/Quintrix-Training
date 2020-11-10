package TheInternet.tests;

import org.testng.annotations.Test;

import TheInternet.foundation.TestBase;
import TheInternet.pages.LoginPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class BasicAuthTest extends TestBase{
	@Test
	public void canLogin() {
		//Arrange
		Boolean expectedLogin = true;
		//Act
		Boolean actualLogin = new LoginPage(driver, baseURL)
				.navigate()
				.login()
				.isLoggedin();
		//Assert
		Assert.assertEquals(actualLogin, expectedLogin);
	}
	@BeforeTest
	public void beforeTest() {
		super.beforeTest();
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
	}

}
