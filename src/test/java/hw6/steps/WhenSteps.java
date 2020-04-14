package hw6.steps;

import hw6.WebDriverSingleton;
import hw6.voids.DifferentElementsPage;
import hw6.voids.IndexPage;
import hw6.voids.UserTablePage;
import io.cucumber.java.en.When;

public class WhenSteps {

	private IndexPage indexPage;
	private DifferentElementsPage differentElementsPage;
	private UserTablePage userTablePage;

    @When("I click on {string} button in Header")
    public void iClickOnButtonInHeader(String button) {
    	indexPage = new IndexPage(WebDriverSingleton.INSTANCE.getDriver());
    	indexPage.clickMenuButton(button);
    }

    @When("I click on {string} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String button) {
    	indexPage.clickDropdownButton(button);
    }

    @When("I select checkbox as {string}")
    public void iSelectCheckboxAs(String checkbox) {
    	differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
    	differentElementsPage.selectCheckbox(checkbox);
    }

    @When("I select radio as {string}")
    public void iSelectRadioAs(String radio) {
    	differentElementsPage.selectRadio(radio);
    }

    @When("I select color as {string}")
    public void iSelectColorAs(String color) {
    	differentElementsPage.selectColor(color);
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSelectVipCheckboxFor(String name) {
    	userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
    	userTablePage.selectCheckboxFor(name);
    }

}