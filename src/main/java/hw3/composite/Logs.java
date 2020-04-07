package hw3.composite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logs extends AbstractPage {

    @FindBy(css = ".logs > li")
    private List<WebElement> logs;

    public Logs(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckboxLogDisplayed(String checkbox) {
    	return logs.stream().anyMatch(s -> s.getText().substring(9).equals(checkbox + ": condition changed to true"));
    }

    public boolean isRadioLogDisplayed(String radio) {
    	return logs.stream().anyMatch(s -> s.getText().substring(9).equals("metal: value changed to " + radio));
    }

    public boolean isColorLogDisplayed(String color) {
    	return logs.stream().anyMatch(s -> s.getText().substring(9).equals("Colors: value changed to " + color));
    }

}
