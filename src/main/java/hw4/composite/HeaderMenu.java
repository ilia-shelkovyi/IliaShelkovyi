package hw4.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractPage {

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

    @FindBy(linkText = "TABLE WITH PAGES")
    private WebElement tableWithPages;

    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalsColors;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
    	userIcon.click();
    	loginField.sendKeys(username);
    	passwordField.sendKeys(password);
    	loginButton.click();
    }

    public void goToTableWithPages() {
    	service.click();
    	tableWithPages.click();
    }

    public void goToMetalsColors() {
    	metalsColors.click();
    }

    public boolean isUserNameDisplayed() {
    	return userName.isDisplayed();
    }

    public String getUserNameText() {
    	return userName.getText();
    }

}
