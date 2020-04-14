package hw6;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverBase {

    @Before
    public void setUp() {
        WebDriverSingleton.INSTANCE.createdDriver();
    }

    @After
    public void tearDown() {
    	WebDriverSingleton.INSTANCE.getDriver().quit();
    }

}
