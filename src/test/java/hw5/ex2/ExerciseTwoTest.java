package hw5.ex2;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import hw5.DriverBase;
import hw5.voids.DifferentElementsPage;
import hw5.voids.IndexPage;

public class ExerciseTwoTest extends DriverBase {

    @Test
    public void secondExerciseTests() {
    	IndexPage indexPage = new IndexPage(driver);
    	DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);

    	//1. Open test site by URL
    	indexPage.goTo("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        assertEquals(indexPage.getBrowserTitle(), "Home Page");

        //3. Perform login
        indexPage.login(properties.getProperty("username"), properties.getProperty("password"));

        //4. Assert User name in the left-top side of screen that user is loggined
        assertTrue(indexPage.isUserNameDisplayed());
        assertEquals(indexPage.getUserNameText(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        indexPage.goToDifferentElements();

        //6. Select checkboxes
        differentElementsPage.selectCheckbox("Water");
        differentElementsPage.selectCheckbox("Wind");

        //7. Select radio
        differentElementsPage.selectRadio("Selen");

        //8. Select in dropdown
        differentElementsPage.selectColor("Yellow");
        /*9. Assert that 
        	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        	for radio button there is a log row and value is corresponded to the status of radio button
        	for dropdown there is a log row and value is corresponded to the selected value.*/ 
        assertTrue(differentElementsPage.isCheckboxLogDisplayed("Water"));
        assertTrue(differentElementsPage.isCheckboxLogDisplayed("Wind"));
        assertTrue(differentElementsPage.isRadioLogDisplayed("Selen"));
        assertTrue(differentElementsPage.isColorLogDisplayed("Yellow"));
    }

}
