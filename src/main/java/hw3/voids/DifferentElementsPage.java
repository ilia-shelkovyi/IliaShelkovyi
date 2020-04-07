package hw3.voids;

import org.openqa.selenium.WebDriver;

import hw3.composite.DifferentElementsContent;
import hw3.composite.Logs;

public class DifferentElementsPage extends AbstractPage {

    private DifferentElementsContent differentElementsContent;
    private Logs logs;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.differentElementsContent = new DifferentElementsContent(driver);
        this.logs = new Logs(driver);
    }

    public void selectCheckbox(String checkbox) {
    	differentElementsContent.selectCheckbox(checkbox);
     }

    public void selectRadio(String radio) {
    	differentElementsContent.selectRadio(radio);
     }

    public void selectColor(String color) {
    	differentElementsContent.selectColor(color);
     }

    public boolean isCheckboxLogDisplayed(String checkbox) {
    	return logs.isCheckboxLogDisplayed(checkbox);
    }

    public boolean isRadioLogDisplayed(String radio) {
    	return logs.isRadioLogDisplayed(radio);
    }

    public boolean isColorLogDisplayed(String color) {
    	return logs.isColorLogDisplayed(color);
    }

}
