package hw4.composite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MetalColorsContent extends AbstractPage {

    @FindBy(className = "radio")
    private List<WebElement> summary;

    @FindBy(className = "checkbox")
    private List<WebElement> elements;

    @FindBy(id = "colors")
    private WebElement colorsButton;

    @FindBy(css = "button[title='Metals'] > span.caret")
    private WebElement metalsButton;

    @FindBy(id = "vegetables")
    private WebElement vegetablesButton;

    @FindBy(css = ".dropdown-menu > li")
    private List<WebElement> dropdown;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@class='checkbox']/*[text()='Vegetables']")
    private WebElement vegetablesCheckbox;

    public MetalColorsContent(WebDriver driver) {
        super(driver);
    }

    public void selectSummary(List<String> values) {
    	if(values != null) {
    		selectByList(values, summary);
    	}
    }

    public void selectElements(List<String> values) {
    	if(values != null) {
    		selectByList(values, elements);
    	}
    }

    public void selectColor(String value) {
    	if(value != null) {
	    	colorsButton.click();
	    	selectByString(value);
    	}
    }

    public void selectMetal(String value) {
    	if(value != null) {
	    	metalsButton.click();
	    	selectByString(value);
    	}
    }

    public void selectVegetables(List<String> values) {
		vegetablesButton.click();
		vegetablesCheckbox.click();
        if(values != null) {
        	selectByList(values, dropdown);
    	}
    }

    public void submit() {
    	submitButton.click();
    }

    private void selectByList(List<String> values, List<WebElement> elements) {
    	elements.stream().filter(s -> values.contains(s.getText())).forEach(WebElement::click);
    }

    private void selectByString(String value) {
	    dropdown.stream().filter(s -> s.getText().equals(value)).forEach(WebElement::click);
    }

}
