package hw2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        /*WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();*/
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
    	//12 / 10. Close Browser
        driver.quit();
    }

    public void login(String username, String password) {
	    driver.findElement(By.id("user-icon")).click();
	    driver.findElement(By.id("name")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("login-button")).click();
    }

}
