package hw4.composite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableWithPagesContent extends AbstractPage {

    @FindBy(css = ".uui-form-element > option")
    private List<WebElement> dropdownValues;

    @FindBy(css = "tbody > tr")
    private List<WebElement> tableRows;

    @FindBy(css = "input[type='search']")
    private WebElement searchField;

    public TableWithPagesContent(WebDriver driver) {
        super(driver);
    }

    public void selectDropdownValue(String value) {
    	dropdownValues.stream().filter(s -> s.getText().equals(value)).forEach(WebElement::click);
    }

    public void search(String text) {
    	searchField.sendKeys(text);
    }

    public String getDefaultDropdownValue() {
    	return dropdownValues.get(0).getText();
    }

    public int getTableRowsCount() {
    	return tableRows.size();
    }

    public boolean isTableRowsContains(String text) {
    	return tableRows.stream().allMatch(s -> s.getText().toLowerCase().contains(text.toLowerCase()));
    }
	
}
