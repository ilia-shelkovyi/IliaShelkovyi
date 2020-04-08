package hw3.composite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsContent extends AbstractPage {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(css = ".uui-form-element > option")
    private List<WebElement> colors;

    public DifferentElementsContent(WebDriver driver) {
        super(driver);
    }

    public void selectCheckbox(String checkbox) {
    	selectByString(checkbox, checkboxes);
     }

    public void selectRadio(String radio) {
    	selectByString(radio, radios);
     }

    public void selectColor(String color) {
    	selectByString(color, colors);
     }

    private void selectByString(String value, List<WebElement> elements) {
    	elements.stream().filter(s -> s.getText().equals(value)).forEach(WebElement::click);
     }

}
