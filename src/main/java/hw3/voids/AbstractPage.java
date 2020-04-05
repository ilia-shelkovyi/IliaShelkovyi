package hw3.voids;

import org.openqa.selenium.WebDriver;

import hw3.composite.HeaderMenu;
import hw3.composite.LeftMenu;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected HeaderMenu headerMenu;
    protected LeftMenu leftMenu;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.leftMenu = new LeftMenu(driver);
    }

}
