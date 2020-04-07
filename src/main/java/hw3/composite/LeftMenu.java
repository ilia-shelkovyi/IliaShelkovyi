package hw3.composite;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu extends AbstractPage {

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> menuItems;

    @FindBy(linkText = "Service")
    private WebElement service;

    @FindBy(linkText = "Different elements")
    private WebElement differentElements;

    public LeftMenu(WebDriver driver) {
        super(driver);
    }

    public void goToDifferentElements() {
    	service.click();
    	differentElements.click();
    }

    public boolean isMenuItemsDisplayed() {
    	return menuItems.stream().allMatch(WebElement::isDisplayed);
    }

    public List<String> getMenuItemsText() {
    	return menuItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
