package hw3.composite;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexContent extends AbstractPage {

    @FindBy(className = "icon-practise")
    private List<WebElement> images;

    @FindBy(className = "benefit-txt")
    private List<WebElement> imageTexts;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IndexContent(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame() {
    	driver.switchTo().frame(frame);
    }

    public boolean isImagesDisplayed() {
    	return images.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isImageTextsDisplayed() {
    	return imageTexts.stream().allMatch(WebElement::isDisplayed);
    }

	public List<String> getImageTextsText() {
		return imageTexts.stream().map(WebElement::getText).collect(Collectors.toList());
	}

    public boolean isFrameDisplayed() {
    	return frame.isDisplayed();
    }

    public boolean isFrameButtonDisplayed() {
    	return frameButton.isDisplayed();
    }

}
