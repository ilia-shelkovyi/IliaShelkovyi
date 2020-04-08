package hw4.composite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Results extends AbstractPage {

    @FindBy(css = ".results > li")
    private List<WebElement> results;

    public Results(WebDriver driver) {
        super(driver);
    }

    public boolean isResultsContainsSummary(List<String> text) {
    	int sum = text.stream().mapToInt(Integer::parseInt).sum();
    	return isResultsContainsColorMetal(String.valueOf(sum));
    }

    public boolean isResultsContainsElementsVegetables(List<String> text) {
    	return text.stream().allMatch(s -> isResultsContainsColorMetal(s));
    }

    public boolean isResultsContainsColorMetal(String text) {
    	return results.stream().anyMatch(s -> s.getText().contains(text));
    }

}
