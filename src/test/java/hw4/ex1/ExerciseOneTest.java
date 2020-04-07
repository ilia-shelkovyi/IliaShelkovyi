package hw4.ex1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import hw4.DriverBase;
import hw4.voids.IndexPage;
import hw4.voids.TableWithPagesPage;

public class ExerciseOneTest extends DriverBase {

    @Test
    public void firstExerciseTests() {
        IndexPage indexPage = new IndexPage(driver);
        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage(driver);

    	//1. Open test site by URL
        indexPage.goTo("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        assertEquals(indexPage.getBrowserTitle(), "Home Page");

        //3. Perform login
        indexPage.login(properties.getProperty("username"), properties.getProperty("password"));

        //4. Assert User name in the left-top side of screen that user is loggined
        assertTrue(indexPage.isUserNameDisplayed());
        assertEquals(indexPage.getUserNameText(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Table with pages
        indexPage.goToTableWithPages();

        //6. Check that default value for “Show entries” dropdown is 5
        assertEquals(tableWithPagesPage.getDefaultDropdownValue(), "5");

        //7. Select new value for the entries in the dropdown list
        tableWithPagesPage.selectDropdownValue("10");

        //8. Assert that in the table displayed corrected amount of entries
        assertEquals(tableWithPagesPage.getTableRowsCount(), 10);

        //9. Type in “Search” text field
        tableWithPagesPage.search("junit");

        //10. Assert the table contains only records with Search field value
        assertTrue(tableWithPagesPage.isTableRowsContains("junit"));
    }

}
