package TheInternet.controls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {
	private WebElement mappedElement;
	private By columnHeaderLocator = By.cssSelector("thead th");

	public Table(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	private List<WebElement> getColumnHeaders(){
		List<WebElement> columnHeaders = this.mappedElement.findElements(columnHeaderLocator );
		return columnHeaders;
	}
	
	public TableRow getRow(int i) {
		List<WebElement> rowElements = this.mappedElement.findElements(By.cssSelector("tbody tr"));
		WebElement selectedRow = rowElements.get(i-1);
		return new TableRow(selectedRow, getColumnHeaders());
	}
	
}
