package hw6.voids;

import org.openqa.selenium.WebDriver;

public class IndexPage extends AbstractPage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(String url) {
    	driver.get(url);
    }

    public String getBrowserTitle() {
    	return driver.getTitle();
    }

    public void login(String username, String password) {
        headerMenu.login(username, password);
    }

    public boolean isUserNameDisplayed() {
    	return headerMenu.isUserNameDisplayed();
    }

    public String getUserNameText() {
    	return headerMenu.getUserNameText();
    }

    public void clickMenuButton(String value) {
    	headerMenu.clickMenuButton(value);
    }

    public void clickDropdownButton(String value) {
    	headerMenu.clickDropdownButton(value);
    }

}
