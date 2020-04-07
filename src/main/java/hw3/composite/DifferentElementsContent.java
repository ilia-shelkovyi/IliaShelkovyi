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
    	checkboxes.stream().filter(s -> s.getText().equals(checkbox)).forEach(WebElement::click);
     }

    public void selectRadio(String radio) {
    	radios.stream().filter(s -> s.getText().equals(radio)).forEach(WebElement::click);
     }

    public void selectColor(String color) {
    	colors.stream().filter(s -> s.getText().equals(color)).forEach(WebElement::click);
     }

}
