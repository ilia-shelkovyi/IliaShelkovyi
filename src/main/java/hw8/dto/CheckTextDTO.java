package hw8.dto;

import static hw8.enums.Params.*;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CheckTextDTO {

    private String text;
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