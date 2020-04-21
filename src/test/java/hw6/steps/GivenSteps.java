package hw6.steps;

import hw6.WebDriverSingleton;
import hw6.voids.IndexPage;
import io.cucumber.java.en.Given;

public class GivenSteps {

	private IndexPage indexPage;

    @Given("I open JDI GitHub site")
    public void iOpenJDIGitHubSite() {
        indexPage = new IndexPage(WebDriverSingleton.INSTANCE.getDriver());
        indexPage.goTo("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Given("I login as username {string} and password {string}")
    public void iLoginAs(String username, String password) {
    	indexPage.login(username, password);
    }

}