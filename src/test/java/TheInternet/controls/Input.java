package TheInternet.controls;

import org.openqa.selenium.WebElement;

public class Input {
	WebElement mappedElement;
	
	public Input(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	
	public void setText(String expectedInput) {
		mappedElement.sendKeys(expectedInput);
		String value = mappedElement.getAttribute("value");
		if(!value.equals(expectedInput)) {
			throw new RuntimeException("Value was not set");
		}
	}

	public String getText() {
		return mappedElement.getAttribute("value");
	}
	
	
}
