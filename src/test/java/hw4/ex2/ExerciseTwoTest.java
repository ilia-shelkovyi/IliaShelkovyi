package hw4.ex2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import hw4.DriverBase;
import hw4.builder.MetalsColorsForm;
import hw4.voids.IndexPage;
import hw4.voids.MetalsColorsPage;

public class ExerciseTwoTest extends DriverBase {

    @DataProvider
    public Object[][] metalsColorsBuilder() {
        return new Object[][] {
                {MetalsColorsForm.builder().setElements(Arrays.asList("Earth")).setColor("Yellow").setMetal("Gold").build()},
                {MetalsColorsForm.builder().setSummary(Arrays.asList("3", "8")).setVegetables(Arrays.asList("Cucumber", "Tomato")).build()},
                {MetalsColorsForm.builder().setSummary(Arrays.asList("3", "2")).setElements(Arrays.asList("Wind", "Fire", "Water"))
                	.setMetal("Bronze").setVegetables(Arrays.asList("Onion")).build()},
                {MetalsColorsForm.builder().setSummary(Arrays.asList("6", "5")).setElements(Arrays.asList("Water")).setColor("Green")
                    .setMetal("Selen").setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).build()},
                {MetalsColorsForm.builder().setElements(Arrays.asList("Fire")).setColor("Blue")
                    .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).build()}
        };
    }
    @Test(dataProvider = "metalsColorsBuilder")
    public void secondExerciseTests(MetalsColorsForm metalsColorsForm) {
    	IndexPage indexPage = new IndexPage(driver);
    	MetalsColorsPage metalsColorsPage = new MetalsColorsPage(driver);

    	//1. Open test site by URL
    	indexPage.goTo("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Perform login
        indexPage.login(properties.getProperty("username"), properties.getProperty("password"));

        //3. Click on the link on the Header section
        indexPage.goToMetalsColors();

        //4. Fill form on the page
        metalsColorsPage.selectSummary(metalsColorsForm.getSummary());
        metalsColorsPage.selectElements(metalsColorsForm.getElements());
        metalsColorsPage.selectColor(metalsColorsForm.getColor());
        metalsColorsPage.selectMetal(metalsColorsForm.getMetal());
        metalsColorsPage.selectVegetables(metalsColorsForm.getVegetables());

        //5. Click “Submit” button
        metalsColorsPage.submit();
        

        //6. Check Results block output on the right-side
        if(metalsColorsForm.getSummary() != null) {
        	assertTrue(metalsColorsPage.isResultsContainsSummary(metalsColorsForm.getSummary()));
        }
        if(metalsColorsForm.getElements() != null) {
        	assertTrue(metalsColorsPage.isResultsContainsElementsVegetables(metalsColorsForm.getElements()));
        }
        if(metalsColorsForm.getColor() != null) {
        	assertTrue(metalsColorsPage.isResultsContainsColorMetal(metalsColorsForm.getColor()));
        }
        if(metalsColorsForm.getMetal() != null) {
        	assertTrue(metalsColorsPage.isResultsContainsColorMetal(metalsColorsForm.getMetal()));
        }
        if(metalsColorsForm.getVegetables() != null) {
        	assertTrue(metalsColorsPage.isResultsContainsElementsVegetables(metalsColorsForm.getVegetables()));
        }
    }

}
