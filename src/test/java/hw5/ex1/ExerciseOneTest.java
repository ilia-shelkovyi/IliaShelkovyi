package hw5.ex1;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import hw5.DriverBase;
import hw5.steps.IndexPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class ExerciseOneTest extends DriverBase {

    @Feature("Test functionality of JDI site")
    @Story("Exercise one from hw3 test")
    @Test
    public void firstExerciseTests() {
    	IndexPageSteps indexPageSteps = new IndexPageSteps(driver);

    	//1. Open test site by URL
        indexPageSteps.goTo("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        indexPageSteps.browserTitleShouldBe("Home Page");

        //3. Perform login
        indexPageSteps.loginAs(properties.getProperty("username"), properties.getProperty("password"));

        //4. Assert Username is loggined
        indexPageSteps.userNameShouldBeDisplayed();
        indexPageSteps.userNameShouldBe("ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        indexPageSteps.menuButtonsShouldBeDisplayed();
        indexPageSteps.menuButtonsShouldBe(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        //6. Assert that there are 4 images on the Index Page and they are displayed
        indexPageSteps.imagesShouldBeDisplayed();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        indexPageSteps.imageTextsShouldBeDisplayed();
        List<String> expectedImageTexts = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
        	"To be flexible and\ncustomizable", "To be multiplatform",
        	"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        indexPageSteps.imageTextsShouldBe(expectedImageTexts);

        //8. Assert that there is the iframe with “Frame Button” exist
        indexPageSteps.frameShouldBeDisplayed();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPageSteps.switchToFrame();
        indexPageSteps.frameButtonShouldBeDisplayed();

        //10. Switch to original window back
        indexPageSteps.switchToDefaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        indexPageSteps.leftMenuItemsShouldBeDisplayed();
        indexPageSteps.leftMenuItemsShouldBe(Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));
    }

}
