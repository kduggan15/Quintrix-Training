package TheInternet.foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectBase {
	protected WebDriver driver;
	protected String url;
	
	public PageObjectBase(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
		PageFactory.initElements(driver, this);
	}
	public void navigate(String ext) {
		driver.navigate().to(url+ext);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
