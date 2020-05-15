package hw8.dto;

import static hw8.enums.Params.LANG;
import static hw8.enums.Params.OPTIONS;
import static hw8.enums.Params.TEXT;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CheckTextsDTO {

    private String[] text;
    private String lang;
    private int options;

    public Map<String, Object> getParamsMap() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(TEXT.getValue(), text);
        params.put(LANG.getValue(), lang);
        params.put(OPTIONS.getValue(), options);
        return params;
    }

}