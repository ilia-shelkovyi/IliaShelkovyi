package hw5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverBase {

    protected WebDriver driver;
    protected Properties properties = new Properties();
    private static final String PATH = "src/test/resources/config.properties";

    @BeforeMethod
    public void setUp() {
        WebDriverSingleton.INSTANCE.createdDriver();
        driver = WebDriverSingleton.INSTANCE.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        try(FileInputStream fileInputStream = new FileInputStream(PATH)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
    	//12 / 10. Close Browser
    	WebDriverSingleton.INSTANCE.getDriver().quit();
    }

}
