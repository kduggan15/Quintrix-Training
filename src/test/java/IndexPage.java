import org.openqa.selenium.WebDriver;

public class IndexPage {
	private WebDriver driver;
	private String url;
	
	public IndexPage(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}
	public IndexPage navigate() {
		driver.navigate().to(url);
		return this;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
