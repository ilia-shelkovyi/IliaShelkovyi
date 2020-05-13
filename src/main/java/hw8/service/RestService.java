package hw8.service;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import hw8.dto.CheckTextDTO;
import hw8.dto.CheckTextsDTO;
import hw8.dto.RestDTO;

import static hw8.enums.Params.*;

public class RestService {

    public RestDTO[] checkText(CheckTextDTO request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(TEXT.getValue(), request.getText());
        params.put(LANG.getValue(), request.getLang());
        params.put(OPTIONS.getValue(), request.getOptions());
        return new Gson().fromJson(new CommonService()
		        .getResponse(CHECK_TEXT.getValue(), params)
		        .getBody().asString(), RestDTO[].class);
    }

    public RestDTO[][] checkTexts(CheckTextsDTO request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(TEXT.getValue(), request.getText());
        params.put(LANG.getValue(), request.getLang());
        params.put(OPTIONS.getValue(), request.getOptions());
        return new Gson().fromJson(new CommonService()
		        .getResponse(CHECK_TEXTS.getValue(), params)
		        .getBody().asString(), RestDTO[][].class);
    }

}
