package hw8.service;

import com.google.gson.Gson;

import hw8.dto.CheckTextDTO;
import hw8.dto.CheckTextsDTO;
import hw8.dto.RestDTO;

import static hw8.enums.Params.*;

public class RestService {

    public RestDTO[] checkText(CheckTextDTO request) {
        return new Gson().fromJson(new CommonService()
		        .getResponse(CHECK_TEXT.getValue(), request.getParamsMap())
		        .getBody().asString(), RestDTO[].class);
    }

    public RestDTO[][] checkTexts(CheckTextsDTO request) {
        return new Gson().fromJson(new CommonService()
		        .getResponse(CHECK_TEXTS.getValue(), request.getParamsMap())
		        .getBody().asString(), RestDTO[][].class);
    }

}
