package hw6.voids;

import java.util.List;

import org.openqa.selenium.WebDriver;

import hw6.composite.Logs;
import hw6.composite.UserTableContent;
import hw6.entities.UserTableRow;

public class UserTablePage extends AbstractPage {

    private UserTableContent userTableContent;
    private Logs logs;

    public UserTablePage(WebDriver driver) {
        super(driver);
        this.userTableContent = new UserTableContent(driver);
        this.logs = new Logs(driver);
    }

    public int getDropdownsCount() {
    	return userTableContent.getDropdownsCount();
    }

    public int getUsernamesCount() {
    	return userTableContent.getDropdownsCount();
    }

    public int getDescriptionTextsCount() {
    	return userTableContent.getDropdownsCount();
    }

    public int getCheckboxesCount() {
    	return userTableContent.getDropdownsCount();
    }

    public List<UserTableRow> getUserTableData() {
    	return userTableContent.getUserTableData();
    }

    public List<String> getDropdownTexts() {
    	return userTableContent.getDropdownTexts();
    }

    public void selectCheckboxFor(String name) {
    	userTableContent.selectCheckboxFor(name);
    }

    public int getLogRowCountFor(String log) {
    	return logs.getLogRowCountFor(log);
    }

}
