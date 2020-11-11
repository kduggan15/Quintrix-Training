package TheInternet.controls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableRow {
	
	private WebElement mappedElement;
	private List<WebElement> columnHeaders;

	public TableRow(WebElement selectedRow, List<WebElement> headers) {
		this.mappedElement = selectedRow;
		this.columnHeaders = headers;
	}

	public WebElement getCell(String label) {
		int colNum=-1;
		for(int i =0; i<columnHeaders.size();i++) {
			if(columnHeaders.get(i).getText().equals(label)) {
				colNum = i;
				break;
			}
		}
		return mappedElement.findElements(By.cssSelector("td")).get(colNum);
	}
	
}
