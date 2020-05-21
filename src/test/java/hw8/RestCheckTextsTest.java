package hw8;

import org.testng.annotations.Test;

import hw8.dto.CheckTextsDTO;
import hw8.dto.RestDTO;
import hw8.service.RestAsserts;
import hw8.service.RestService;

public class RestCheckTextsTest {

    @Test(dataProviderClass = RestDataProvider.class, dataProvider = "correctWordsDataProvider")
    public void correctWordsTest(String[] text, String lang) {
    	CheckTextsDTO request = CheckTextsDTO.builder().text(text).lang(lang).build();
        RestDTO[][] result = new RestService().checkTexts(request);
        new RestAsserts(result)
        		.verifyEmptyResponses();
    }

    @Test(dataProviderClass = RestDataProvider.class, dataProvider = "incorrectWordsDataProvider")
    public void incorrectWordsTest(String text[], String lang, String[] expected, int code) {
    	CheckTextsDTO request = CheckTextsDTO.builder().text(text).lang(lang).build();
        RestDTO[][] result = new RestService().checkTexts(request);
        new RestAsserts(result)
        		.verifyNotEmptyResponses()
        		.verifyErrors(code);
    }

}
