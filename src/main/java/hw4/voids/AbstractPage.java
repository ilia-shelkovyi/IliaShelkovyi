package hw4.voids;

import org.openqa.selenium.WebDriver;

import hw4.composite.HeaderMenu;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected HeaderMenu headerMenu;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
    }

}
