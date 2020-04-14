package hw5.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import hw5.voids.IndexPage;
import io.qameta.allure.Step;

public class IndexPageSteps {

	private IndexPage indexPage;

    public IndexPageSteps(WebDriver driver) {
        this.indexPage = new IndexPage(driver);
    }

    @Step("Go to '{0}'")
    public void goTo(String url) {
        indexPage.goTo(url);
    }

    @Step("Browser title should be '{0}'")
    public void browserTitleShouldBe(String expectedBrowserTitle) {
    	assertEquals(indexPage.getBrowserTitle(), expectedBrowserTitle);
    }

    @Step("Login as username '{0}' and password '{1}'")
    public void loginAs(String username, String password) {
    	indexPage.login(username, password);
    }

    @Step("Username should be displayed")
    public void userNameShouldBeDisplayed() {
    	assertTrue(indexPage.isUserNameDisplayed());
    }

    @Step("Username should be '{0}'")
    public void userNameShouldBe(String expectedUserName) {
    	assertEquals(indexPage.getUserNameText(), expectedUserName);
    }

    @Step("Menu buttons should be displayed")
    public void menuButtonsShouldBeDisplayed() {
    	assertTrue(indexPage.isHeaderMenuButtonsDisplayed());
    }

    @Step("Menu buttons should be '{0}'")
    public void menuButtonsShouldBe(List<String> expectedMenuButtons) {
	    assertEquals(indexPage.getHeaderMenuButtonsText(), expectedMenuButtons);
    }

    @Step("Images should be displayed")
    public void imagesShouldBeDisplayed() {
    	assertTrue(indexPage.isImagesDisplayed());
    }

    @Step("Image texts should be displayed")
    public void imageTextsShouldBeDisplayed() {
    	assertTrue(indexPage.isImageTextsDisplayed());
    }

    @Step("Image texts should be '{0}'")
    public void imageTextsShouldBe(List<String> expectedImageTexts) {
    	assertEquals(indexPage.getImageTextsText(), expectedImageTexts);
    }

    @Step("Frame should be displayed")
    public void frameShouldBeDisplayed() {
    	assertTrue(indexPage.isFrameDisplayed());
    }

    @Step("Switch to frame")
    public void switchToFrame() {
    	indexPage.switchToFrame();
    }

    @Step("Frame button should be displayed")
    public void frameButtonShouldBeDisplayed() { 
    	assertTrue(indexPage.isFrameButtonDisplayed());
    }

    @Step("Switch to default content")
    public void switchToDefaultContent() {
    	indexPage.switchToDefaultContent();
    }

    @Step("Left menu items should be displayed")
    public void leftMenuItemsShouldBeDisplayed() {
    	assertTrue(indexPage.isLeftMenuItemsDisplayed());
    }

    @Step("Left menu items should be '{0}'")
    public void leftMenuItemsShouldBe(List<String> expectedLeftMenuItems) {
	    assertEquals(indexPage.getLeftMenuItemsText(), expectedLeftMenuItems);
    }

    @Step("Go to different elements")
    public void goToDifferentElements() {
    	indexPage.goToDifferentElements();
    }

}
