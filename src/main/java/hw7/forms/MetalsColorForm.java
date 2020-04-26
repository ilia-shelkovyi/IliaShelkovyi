package hw7.forms;

import static java.util.Arrays.stream;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

import hw7.enities.MetalsColorsData;

public class MetalsColorForm extends Form<MetalsColorsData> {

    @Css(".radio > input")
    private RadioButtons summary;

    @Css("#elements-checklist input")
    private Checklist elements;

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#vegetables", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown vegetables;

    @Css("#submit-button")
    private Button submit;

    @Override
    public void submit(MetalsColorsData data) {
    	stream(data.getSummary()).forEach(e -> summary.select(String.valueOf(e)));
    	stream(data.getElements()).forEach(e -> elements.select(e));
    	colors.select(data.getColor());
    	metals.select(data.getMetals());
    	vegetables.select("Vegetables");
    	stream(data.getVegetables()).forEach(e -> vegetables.select(e));
    	submit.click();
    }

}
