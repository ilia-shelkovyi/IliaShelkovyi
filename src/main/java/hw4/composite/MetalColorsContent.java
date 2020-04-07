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

    public MetalColorsContent(WebDriver driver) {
        super(driver);
    }

    public void selectSummary(List<String> values) {
    	if(values != null) {
    		summary.stream().filter(s -> values.contains(s.getText())).forEach(WebElement::click);
    	}
    }

    public void selectElements(List<String> values) {
    	if(values != null) {
    		elements.stream().filter(s -> values.contains(s.getText())).forEach(WebElement::click);
    	}
    }

    public void selectColor(String value) {
    	if(value != null) {
	    	colorsButton.click();
	    	dropdown.stream().filter(s -> s.getText().equals(value)).forEach(WebElement::click);
    	}
    }

    public void selectMetal(String value) {
    	if(value != null) {
	    	metalsButton.click();
	    	dropdown.stream().filter(s -> s.getText().equals(value)).forEach(WebElement::click);
    	}
    }

    public void selectVegetables(List<String> values) {
		vegetablesButton.click();
		dropdown.stream().filter(s -> s.getText().equals("Vegetables")).forEach(WebElement::click);
        if(values != null) {
    		dropdown.stream().filter(s -> values.contains(s.getText())).forEach(WebElement::click);
    	}
    }

    public void submit() {
    	submitButton.click();
    }

}
