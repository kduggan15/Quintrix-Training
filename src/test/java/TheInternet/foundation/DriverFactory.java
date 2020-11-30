package TheInternet.foundation;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public WebDriver getDriver(String driverType) {
		WebDriver driver = null;
		if(driverType.equalsIgnoreCase("CHROME")) {
			if(System.getProperty("os.name").contains("Windows")) {
				URL url = ClassLoader.getSystemResource("chromedriver.exe");
				System.setProperty("webdriver.chrome.driver",url.getFile());
				driver = new ChromeDriver();
			}
			else if(System.getProperty("os.name").contains("Linux")) {
				driver = new ChromeDriver();
			}
			else {
				System.out.println(System.getProperty("os.name"));
			}
		}
		return driver;
	}

}
