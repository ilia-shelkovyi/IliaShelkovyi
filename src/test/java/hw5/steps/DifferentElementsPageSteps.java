package hw5.steps;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import hw5.voids.DifferentElementsPage;
import io.qameta.allure.Step;

public class DifferentElementsPageSteps {

	private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        this.differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Select checkbox as '{0}'")
    public void selectCheckbox(String checkbox) {
    	differentElementsPage.selectCheckbox(checkbox);
    }

    @Step("Select radio as '{0}'")
    public void selectRadio(String radio) {
    	differentElementsPage.selectRadio(radio);
    }

    @Step("Select color as '{0}'")
    public void selectColor(String color) {
    differentElementsPage.selectColor(color);
    }

    @Step("Checkbox log should be '{0}'")
    public void checkboxLogShouldBe(String expectedCheckboxLog) {
    	assertTrue(differentElementsPage.isCheckboxLogDisplayed(expectedCheckboxLog));
    }

    @Step("Radio log should be '{0}'")
    public void radioLogShouldBe(String expectedRadioLog) {
    	assertTrue(differentElementsPage.isRadioLogDisplayed(expectedRadioLog));
    }

    @Step("Color log should be '{0}'")
    public void colorLogShouldBe(String expectedColorLog) {
    	assertTrue(differentElementsPage.isColorLogDisplayed(expectedColorLog));
    }

}
