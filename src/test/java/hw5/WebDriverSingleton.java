package hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public enum WebDriverSingleton {

    INSTANCE;

    private WebDriver driver;

    public void createdDriver() {
    	try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
    	} catch (Exception e) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
    	}
    }

    public WebDriver getDriver() {
        return driver;
    }

}