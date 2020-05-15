package hw8.service;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import hw8.dto.RestDTO;

public class RestAsserts {

    private RestDTO[] result;
    private RestDTO[][] results;

    public RestAsserts(RestDTO[] response) {
        this.result = response;
    }

    public RestAsserts(RestDTO[][] response) {
        this.results = response;
    }

    public void verifyEmptyResponse() {
        assertTrue(result.length == 0);
    }

    public void verifyEmptyResponses() {
        assertTrue(results[0].length == 0);
    }

    public RestAsserts verifyNotEmptyResponse() {
        assertTrue(result.length != 0);
        return this;
    }

    public RestAsserts verifyNotEmptyResponses() {
        assertTrue(results[0].length != 0);
        return this;
    }

    public void verifyError(int code) {
    	stream(result).forEach(r -> assertEquals(r.getCode(), code));
    }

    public void verifyErrors(int code) {
        stream(results[0]).forEach(r -> assertEquals(r.getCode(), code));
    }

    public void verifyWord(String word) {
        assertTrue(stream(result[0].getS()).anyMatch(s -> s.equals(word)));	
    }

    public void verifySentence(String[] sentence) {
        assertTrue(stream(result).allMatch(r -> stream(sentence).anyMatch(s -> asList(r.getS()).contains(s))));	
    }

}
