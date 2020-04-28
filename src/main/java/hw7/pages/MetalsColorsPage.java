package hw7.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

import hw7.enities.MetalsColorsData;
import hw7.forms.MetalsColorForm;

@Url("/metals-colors.html")
public class MetalsColorsPage extends WebPage {

    @Css(".form")
    private MetalsColorForm form;
    
    @Css(".results")
    private Section results;

    public void submit(MetalsColorsData data) {
    	form.submit(data);
    }

    public void checkResults(MetalsColorsData data) {
    	results.is().text(data.toString());
    }

}
