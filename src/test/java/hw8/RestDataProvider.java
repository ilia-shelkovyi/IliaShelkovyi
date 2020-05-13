package hw8;

import static hw8.enums.Lang.*;

import org.testng.annotations.DataProvider;

public class RestDataProvider {

    @DataProvider
    public Object[][] correctWordDataProvider() {
    	return new Object[][] {
    			{"машина", RU.getValue()},
    			{"hello", EN.getValue()},
    	};
    }

    @DataProvider
    public Object[][] incorrectWordDataProvider() {
    	return new Object[][] {
    			{"машына", RU.getValue(), "машина"},
    			{"helo", EN.getValue(), "hello"},
    	};
    }

    @DataProvider
    public Object[][] repeatedWordDataProvider() {
    	return new Object[][] {
    			{"приветпривет", RU.getValue(), "привет привет"},
    			{"hellohello", EN.getValue(), "hello hello"},
    	};
    }

    @DataProvider
    public Object[][] incorrectSentenceDataProvider() {
    	return new Object[][] {
    			{"качесвеная програма", RU.getValue(), new String[]{"качественная", "программа"}},
    			{"праверка роботы", RU.getValue(), new String[]{"проверка", "работы"}},
    	};
    }

    @DataProvider
    public Object[][] correctWordsDataProvider() {
    	return new Object[][] {
    			{new String[]{"машина", "привет"}, RU.getValue()},
    			{new String[]{"program", "hello"}, EN.getValue()},
    	};
    }

    @DataProvider
    public Object[][] incorrectWordsDataProvider() {
    	return new Object[][] {
    			{new String[]{"машына", "превет"}, RU.getValue(), new String[]{"машина", "привет"}},
    			{new String[]{"programm", "helo"}, EN.getValue(), new String[]{"program", "hello"}},
    	};
    }

}
