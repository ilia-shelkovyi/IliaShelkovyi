package hw5.ex2;

import org.testng.annotations.Test;

import hw5.DriverBase;
import hw5.steps.DifferentElementsPageSteps;
import hw5.steps.IndexPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class ExerciseTwoTest extends DriverBase {

    @Feature("Test functionality of JDI site")
    @Story("Exercise two from hw3 test")
    @Test
    public void secondExerciseTests() {
    	IndexPageSteps indexPageSteps = new IndexPageSteps(driver);
    	DifferentElementsPageSteps differentElementsPageSteps = new DifferentElementsPageSteps(driver);

    	//1. Open test site by URL
    	indexPageSteps.goTo("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
    	indexPageSteps.browserTitleShouldBe("Home Page");

        //3. Perform login
    	indexPageSteps.loginAs(properties.getProperty("username"), properties.getProperty("password"));

        //4. Assert User name in the left-top side of screen that user is loggined
        indexPageSteps.userNameShouldBeDisplayed();
        indexPageSteps.userNameShouldBe("ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        indexPageSteps.goToDifferentElements();

        //6. Select checkboxes
        differentElementsPageSteps.selectCheckbox("Water");
        differentElementsPageSteps.selectCheckbox("Wind");

        //7. Select radio
        differentElementsPageSteps.selectRadio("Selen");

        //8. Select in dropdown
        differentElementsPageSteps.selectColor("Yellow");
        /*9. Assert that 
        	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        	for radio button there is a log row and value is corresponded to the status of radio button
        	for dropdown there is a log row and value is corresponded to the selected value.*/ 
        differentElementsPageSteps.checkboxLogShouldBe("Water");
        differentElementsPageSteps.checkboxLogShouldBe("Wind");
        differentElementsPageSteps.radioLogShouldBe("Selen");
        differentElementsPageSteps.colorLogShouldBe("Yellow");
    }

}
