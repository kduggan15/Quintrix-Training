import org.openqa.selenium.WebElement;

public class CheckBox {
	WebElement mappedElement;
	
	public CheckBox(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	
	public void setBox() {
		if (!mappedElement.isSelected()) {
			mappedElement.click();
		}
		
	}

	public Boolean getBox() {
		return mappedElement.isSelected();
	}
}
