package hw4.voids;

import java.util.List;

import org.openqa.selenium.WebDriver;

import hw4.composite.MetalColorsContent;
import hw4.composite.Results;

public class MetalsColorsPage extends AbstractPage {

	private MetalColorsContent metalColorsContent;
	private Results results;

    public MetalsColorsPage(WebDriver driver) {
        super(driver);
        this.metalColorsContent = new MetalColorsContent(driver);
        this.results = new Results(driver);
    }

    public void selectSummary(List<String> values) {
    	metalColorsContent.selectSummary(values);
    }

    public void selectElements(List<String> values) {
    	metalColorsContent.selectElements(values);
    }

    public void selectColor(String value) {
    	metalColorsContent.selectColor(value);
    }

    public void selectMetal(String value) {
    	metalColorsContent.selectMetal(value);
    }

    public void selectVegetables(List<String> values) {
    	metalColorsContent.selectVegetables(values);
    }

    public void submit() {
    	metalColorsContent.submit();
    }

    public boolean isResultsContainsSummary(List<String> text) {
    	return results.isResultsContainsSummary(text);
    }

    public boolean isResultsContainsElementsVegetables(List<String> text) {
    	return results.isResultsContainsElementsVegetables(text);
    }

    public boolean isResultsContainsColorMetal(String text) {
    	return results.isResultsContainsColorMetal(text);
    }

}
