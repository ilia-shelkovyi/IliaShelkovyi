package hw6.composite;

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
    	return matchByString(checkbox + ": condition changed to true");
    }

    public boolean isRadioLogDisplayed(String radio) {
    	return matchByString("metal: value changed to " + radio);
    }

    public boolean isColorLogDisplayed(String color) {
    	return matchByString("Colors: value changed to " + color);
    }

    public int getLogRowCountFor(String log) {
    	return (int) logs.stream().filter(s -> s.getText().contains(log)).count();
    }

    private boolean matchByString(String value) {
    	return logs.stream().anyMatch(s -> s.getText().contains(value));
    }

}
