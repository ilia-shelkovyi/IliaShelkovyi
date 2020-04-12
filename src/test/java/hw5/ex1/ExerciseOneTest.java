package hw5.ex1;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import hw5.DriverBase;
import hw5.voids.IndexPage;

public class ExerciseOneTest extends DriverBase {

    @Test
    public void firstExerciseTests() {
        SoftAssert softAssert = new SoftAssert();
        IndexPage indexPage = new IndexPage(driver);

    	//1. Open test site by URL
        indexPage.goTo("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        softAssert.assertEquals(indexPage.getBrowserTitle(), "Home Page");

        //3. Perform login
        indexPage.login(properties.getProperty("username"), properties.getProperty("password"));

        //4. Assert Username is loggined
        softAssert.assertTrue(indexPage.isUserNameDisplayed());
        softAssert.assertEquals(indexPage.getUserNameText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(indexPage.isHeaderMenuButtonsDisplayed());
        List<String> actualMenuButtons = indexPage.getHeaderMenuButtonsText();
        List<String> expectedMenuButtons = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(actualMenuButtons, expectedMenuButtons);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(indexPage.isImagesDisplayed());;

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertTrue(indexPage.isImageTextsDisplayed());;
        List<String> actualImageTexts = indexPage.getImageTextsText();
        List<String> expectedImageTexts = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
        	"To be flexible and\ncustomizable", "To be multiplatform",
        	"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        softAssert.assertEquals(actualImageTexts, expectedImageTexts);

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(indexPage.isFrameDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToFrame();
        softAssert.assertTrue(indexPage.isFrameButtonDisplayed());

        //10. Switch to original window back
        indexPage.switchToDefaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertTrue(indexPage.isLeftMenuItemsDisplayed());;
        List<String> actualLeftMenuItems = indexPage.getLeftMenuItemsText();
        List<String> expectedLeftMenuItems = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertEquals(actualLeftMenuItems, expectedLeftMenuItems);

        softAssert.assertAll();
    }

}
