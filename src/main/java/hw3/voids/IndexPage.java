package hw3.voids;

import java.util.List;

import org.openqa.selenium.WebDriver;

import hw3.composite.IndexContent;

public class IndexPage extends AbstractPage {

    private IndexContent indexContent;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.indexContent = new IndexContent(driver);
    }

    public void goTo(String url) {
    	driver.get(url);
    }

    public String getBrowserTitle() {
    	return driver.getTitle();
    }

    public void switchToDefaultContent() {
    	driver.switchTo().defaultContent();
    }

    public void login(String username, String password) {
        headerMenu.login(username, password);
    }

    public boolean isUserNameDisplayed() {
    	return headerMenu.isUserNameDisplayed();
    }

    public String getUserNameText() {
    	return headerMenu.getUserNameText();
    }

    public boolean isHeaderMenuButtonsDisplayed() {
    	return headerMenu.isMenuButtonsDisplayed();
    }

    public List<String> getHeaderMenuButtonsText() {
    	return headerMenu.getMenuButtonsText();
    }

    public void goToDifferentElements() {
    	leftMenu.goToDifferentElements();
    }

    public boolean isLeftMenuItemsDisplayed() {
    	return leftMenu.isMenuItemsDisplayed();
    }

    public List<String> getLeftMenuItemsText() {
    	return leftMenu.getMenuItemsText();
    }

    public void switchToFrame() {
    	indexContent.switchToFrame();
    }

    public boolean isImagesDisplayed() {
    	return indexContent.isImagesDisplayed();
    }

    public boolean isImageTextsDisplayed() {
    	return indexContent.isImageTextsDisplayed();
    }

    public List<String> getImageTextsText() {
    	return indexContent.getImageTextsText();
    }

    public boolean isFrameDisplayed() {
    	return indexContent.isFrameDisplayed();
    }

    public boolean isFrameButtonDisplayed() {
    	return indexContent.isFrameButtonDisplayed();
    }

}
