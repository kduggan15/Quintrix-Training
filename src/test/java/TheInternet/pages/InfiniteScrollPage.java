package TheInternet.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import TheInternet.foundation.PageObjectBase;

public class InfiniteScrollPage extends PageObjectBase{

	public InfiniteScrollPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public InfiniteScrollPage navigate() {
		super.navigate("/infinite_scroll");
		return this;
	}

	public int getJScrollCount() {
		return driver.findElements(By.cssSelector(".jscroll-added")).size();
	}

	public InfiniteScrollPage scroll() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		return this;
	}

	public InfiniteScrollPage waitForElements() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

}
