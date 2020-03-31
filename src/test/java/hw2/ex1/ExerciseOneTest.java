package hw2.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import hw2.DriverBase;

public class ExerciseOneTest extends DriverBase {

    @Test
    public void firstExerciseTests() {
        SoftAssert softAssert = new SoftAssert();

    	//1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        String browserTitle = driver.getTitle();
        softAssert.assertEquals(browserTitle, "Home Page");

        //3. Perform login
        login("Roman", "Jdi1234");

        //4. Assert Username is loggined
        WebElement userName = driver.findElement(By.id("user-name"));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> menuButtons = driver.findElements(By.cssSelector(".m-l8 > li"));
        menuButtons.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
        List<String> actualMenuButtons = menuButtons.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedMenuButtons = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(actualMenuButtons, expectedMenuButtons);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("icon-practise"));
        images.forEach(e -> softAssert.assertTrue(e.isDisplayed()));

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> imageTexts = driver.findElements(By.className("benefit-txt"));
        imageTexts.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
        List<String> actualImageTexts = imageTexts.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedImageTexts = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
        	"To be flexible and\ncustomizable", "To be multiplatform",
        	"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        softAssert.assertEquals(actualImageTexts, expectedImageTexts);

        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.id("frame"));
        softAssert.assertTrue(iframe.isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftMenuItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        leftMenuItems.forEach(e -> softAssert.assertTrue(e.isDisplayed()));
        List<String> actualLeftMenuItems = leftMenuItems.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedLeftMenuItems = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertEquals(actualLeftMenuItems, expectedLeftMenuItems);

        softAssert.assertAll();
    }

}
