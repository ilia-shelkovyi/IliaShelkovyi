package hw8;

import org.testng.annotations.Test;

import hw8.dto.CheckTextDTO;
import hw8.dto.RestDTO;
import hw8.service.RestAsserts;
import hw8.service.RestService;

public class RestCheckTextTest {

    @Test(dataProviderClass = RestDataProvider.class, dataProvider = "correctWordDataProvider")
    public void correctWordTest(String text, String lang) {
    	CheckTextDTO request = CheckTextDTO.builder().text(text).lang(lang).build();
        RestDTO[] result = new RestService().checkText(request);
        new RestAsserts(result)
        		.verifyEmptyResponse();
    }

    @Test(dataProviderClass = RestDataProvider.class, dataProvider = "incorrectWordDataProvider")
    public void incorrectWordTest(String text, String lang, String expected) {
    	CheckTextDTO request = CheckTextDTO.builder().text(text).lang(lang).build();
        RestDTO[] result = new RestService().checkText(request);
        new RestAsserts(result)
        		.verifyNotEmptyResponse()
        		.verifyWord(expected);
    }

    @Test(dataProviderClass = RestDataProvider.class, dataProvider = "repeatedWordDataProvider")
    public void repeatedWordTest(String text, String lang, String expected) {
    	CheckTextDTO request = CheckTextDTO.builder().text(text).lang(lang).build();
        RestDTO[] result = new RestService().checkText(request);
        new RestAsserts(result)
        		.verifyNotEmptyResponse()
        		.verifyWord(expected);
    }

    @Test(dataProviderClass = RestDataProvider.class, dataProvider = "incorrectSentenceDataProvider")
    public void incorrectSentenceTest(String text, String lang, String[] expected) {
    	CheckTextDTO request = CheckTextDTO.builder().text(text).lang(lang).build();
        RestDTO[] result = new RestService().checkText(request);
        new RestAsserts(result)
        		.verifyNotEmptyResponse()
        		.verifySentence(expected);
    }

}
