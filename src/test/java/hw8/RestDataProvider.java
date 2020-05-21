package hw8;

import static hw8.enums.Errors.*;
import static hw8.enums.Lang.*;
import static hw8.enums.Options.*;

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
    			{"привет привет", RU.getValue(), FIND_REPEAT_WORDS.getValue(), ERROR_REPEAT_WORD.getValue()},
    			{"hello hello", EN.getValue(), FIND_REPEAT_WORDS.getValue(), ERROR_REPEAT_WORD.getValue()},
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
    			{new String[]{"машына", "превет"}, RU.getValue(), new String[]{"машина", "привет"}, ERROR_UNKNOWN_WORD.getValue()},
    			{new String[]{"programm", "helo"}, EN.getValue(), new String[]{"program", "hello"}, ERROR_UNKNOWN_WORD.getValue()},
    	};
    }

}
