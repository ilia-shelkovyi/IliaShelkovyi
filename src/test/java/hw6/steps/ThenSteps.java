package hw6.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import hw6.WebDriverSingleton;
import hw6.entities.UserTableRow;
import hw6.voids.DifferentElementsPage;
import hw6.voids.IndexPage;
import hw6.voids.UserTablePage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

public class ThenSteps {

	private IndexPage indexPage;
	private DifferentElementsPage differentElementsPage;
	private UserTablePage userTablePage;

    @Then("Checkbox log should be {string}")
    public void checkboxLogShouldBe(String expectedCheckboxLog) {
    	differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
    	assertTrue(differentElementsPage.isCheckboxLogDisplayed(expectedCheckboxLog));
    }

    @Then("Radio log should be {string}")
    public void radioLogShouldBe(String expectedRadioLog) {
    	assertTrue(differentElementsPage.isRadioLogDisplayed(expectedRadioLog));
    }

    @Then("Color log should be {string}")
    public void colorLogShouldBe(String expectedColorLog) {
    	assertTrue(differentElementsPage.isColorLogDisplayed(expectedColorLog));
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String expectedPage) {
    	indexPage = new IndexPage(WebDriverSingleton.INSTANCE.getDriver());
    	assertEquals(indexPage.getBrowserTitle(), expectedPage);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayed(int expectedCount) {
    	userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
    	assertEquals(userTablePage.getDropdownsCount(), expectedCount);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayed(int expectedCount) {
    	assertEquals(userTablePage.getDropdownsCount(), expectedCount);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsShouldBeDisplayed(int expectedCount) {
    	assertEquals(userTablePage.getDropdownsCount(), expectedCount);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayed(int expectedCount) {
    	assertEquals(userTablePage.getDropdownsCount(), expectedCount);
    }

    @DataTableType
    public UserTableRow userTable(Map<String, String> userTable) {
        return new UserTableRow(userTable.get("Number"), userTable.get("User"), userTable.get("Description"));
    }

    @Then("User table should contain following values:")
    public void userTableShouldContain(List<UserTableRow> userTableRows) {
    	for(int i = 0; i < userTableRows.size(); i++) {
    		assertEquals(userTablePage.getNumberColumnTexts().get(i), userTableRows.get(i).getNumber());
    		assertEquals(userTablePage.getUserColumnTexts().get(i), userTableRows.get(i).getUser());
    		assertEquals(userTablePage.getDescriptionColumnTexts().get(i), userTableRows.get(i).getDescription());
    	}
    }

    @Then("Droplist should contain values in column Type for user Roman:")
    public void droplistShouldContain(List<String> droplist) {
    	assertEquals(userTablePage.getDropdownTexts(), droplist.subList(1, droplist.size()));
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHas(int count, String log) {
    	userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
    	assertEquals(userTablePage.getLogRowCountFor(log), count);
    }

}