package hw3.composite;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractPage {

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> menuButtons;

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

    public boolean isMenuButtonsDisplayed() {
    	return menuButtons.stream().allMatch(WebElement::isDisplayed);
    }

	public List<String> getMenuButtonsText() {
		return menuButtons.stream().map(WebElement::getText).collect(Collectors.toList());
	}

}
