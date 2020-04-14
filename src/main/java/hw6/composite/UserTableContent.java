package hw6.composite;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTableContent extends AbstractPage {

    @FindBy(xpath = "//tr/td[1]")
    private List<WebElement> numbers;

    @FindBy(tagName = "select")
    private List<WebElement> dropdowns;

    @FindBy(css = "td > a")
    private List<WebElement> usernames;

    @FindBy(css = ".user-descr > span")
    private List<WebElement> descriptionTexts;

    @FindBy(css = ".user-descr > input")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//tbody/tr[2]//option")
    private List<WebElement> dropdownRoman;

    public UserTableContent(WebDriver driver) {
        super(driver);
    }

    public int getDropdownsCount() {
    	return dropdowns.size();
    }

    public int getUsernamesCount() {
    	return usernames.size();
    }

    public int getDescriptionTextsCount() {
    	return descriptionTexts.size();
    }

    public int getCheckboxesCount() {
    	return checkboxes.size();
    }

    public List<String> getNumberColumnTexts() {
    	return getTexts(numbers);
    }

    public List<String> getUserColumnTexts() {
    	return getTexts(usernames);
    }

    public List<String> getDescriptionColumnTexts() {
    	return getTexts(descriptionTexts).stream().map(s -> s.replaceAll("\n", " ")).collect(Collectors.toList());
    }

    public List<String> getDropdownTexts() {
    	return getTexts(dropdownRoman);
    }

    public void selectCheckboxFor(String name) {
    	int position = usernames.stream().map(WebElement::getText).collect(Collectors.toList()).indexOf(name);
    	checkboxes.get(position).click();
    }

    private List<String> getTexts(List<WebElement> elements) {
    	return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
