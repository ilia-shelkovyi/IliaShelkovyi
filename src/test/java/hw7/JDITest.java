package hw7;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import hw7.enities.MetalsColorsData;
import hw7.enities.User;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import java.io.IOException;
import java.nio.file.Paths;

public class JDITest {

	private static final String PATH = "src/test/resources/hw7/MetalsColorsDataSet.json";

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initElements(JDISite.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        getDriver().quit();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @DataProvider
    public Object[] metalsColorsDataProvider() throws IOException {
        return new ObjectMapper().readValue(Paths.get(PATH).toFile(), MetalsColorsData[].class);
    }
    @Test(dataProvider = "metalsColorsDataProvider")
    public void jdiTest(MetalsColorsData metalsColorsData) {
        JDISite.open();
        JDISite.homePage.checkOpened();
        JDISite.homePage.login(User.ROMAN);
        JDISite.homePage.checkLogged(User.ROMAN);
        JDISite.homePage.select("Metals & Colors");
        JDISite.metalsColorsPage.checkOpened();
        JDISite.metalsColorsPage.submit(metalsColorsData);
        JDISite.metalsColorsPage.checkResults(metalsColorsData);
    }

}