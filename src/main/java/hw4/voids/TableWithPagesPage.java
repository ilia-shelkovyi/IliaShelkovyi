package hw4.voids;

import org.openqa.selenium.WebDriver;

import hw4.composite.TableWithPagesContent;

public class TableWithPagesPage extends AbstractPage {

    private TableWithPagesContent tableWithPagesContent;

    public TableWithPagesPage(WebDriver driver) {
        super(driver);
        this.tableWithPagesContent = new TableWithPagesContent(driver);
    }

    public void selectDropdownValue(String value) {
    	tableWithPagesContent.selectDropdownValue(value);
    }

    public void search(String text) {
    	tableWithPagesContent.search(text);
    }

    public String getDefaultDropdownValue() {
    	return tableWithPagesContent.getDefaultDropdownValue();
    }

    public int getTableRowsCount() {
    	return tableWithPagesContent.getTableRowsCount();
    }

    public boolean isTableRowsContains(String text) {
    	return tableWithPagesContent.isTableRowsContains(text);
    }

}
