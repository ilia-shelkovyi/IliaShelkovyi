package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import hw2.DriverBase;

public class ExerciseTwoTest extends DriverBase {

    @Test
    public void secondExerciseTests() {
    	//1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        String browserTitle = driver.getTitle();
        assertEquals(browserTitle, "Home Page");

        //3. Perform login
        login("Roman", "Jdi1234");

        //4. Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.id("user-name"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Different elements")).click();

        //6. Select checkboxes
        WebElement water = driver.findElement(By.cssSelector(".label-checkbox:nth-child(1)"));
        water.click();
        WebElement wind = driver.findElement(By.cssSelector(".label-checkbox:nth-child(3)"));
        wind.click();

        //7. Select radio
        WebElement selen = driver.findElement(By.cssSelector(".label-radio:nth-child(4)"));
        selen.click();

        //8. Select in dropdown
        WebElement yellow = driver.findElement(By.cssSelector(".uui-form-element > option:nth-child(4)"));
        yellow.click();

        /*9. Assert that 
        	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        	for radio button there is a log row and value is corresponded to the status of radio button
        	for dropdown there is a log row and value is corresponded to the selected value.*/ 
        assertEquals(water.getText(), "Water");
        assertEquals(wind.getText(), "Wind");
        assertEquals(selen.getText(), "Selen");
        assertEquals(yellow.getText(), "Yellow");
        List<WebElement> logs = driver.findElements(By.cssSelector(".logs > li"));
        List<String> actualLogs = logs.stream().map((WebElement::getText)).map(s -> s.substring(9)).collect(Collectors.toList());
        List<String> expectedLogs = Arrays.asList("Colors: value changed to Yellow", "metal: value changed to Selen",
        	"Wind: condition changed to true", "Water: condition changed to true");
        assertEquals(actualLogs, expectedLogs);
    }

}
