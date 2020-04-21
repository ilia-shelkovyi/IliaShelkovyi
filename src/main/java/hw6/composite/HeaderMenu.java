package hw6.composite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractPage {

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> menuButtons;

    @FindBy(css = ".dropdown-menu > li > a")
    private List<WebElement> dropdownButtons;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "dropdown-toggle")
    private WebElement service;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
    	userIcon.click();
    	loginField.sendKeys(username);
    	passwordField.sendKeys(password);
    	loginButton.click();
    }

    public boolean isUserNameDisplayed() {
    	return userName.isDisplayed();
    }

    public String getUserNameText() {
    	return userName.getText();
    }

    public void clickMenuButton(String value) {
    	clickByString(value, menuButtons);
    }

    public void clickDropdownButton(String value) {
    	clickByString(value, dropdownButtons);
    }

    private void clickByString(String value, List<WebElement> elements) {
    	elements.stream().filter(s -> s.getText().equalsIgnoreCase(value)).limit(1).forEach(WebElement::click);
    }

}
