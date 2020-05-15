package hw8.enums;

import static utils.PropertyReader.get;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Params {

    URI(get("uri")),
    CHECK_TEXT("checkText"),
    CHECK_TEXTS("checkTexts"),
    TEXT("text"),
    LANG("lang"),
    OPTIONS("options");

    private String value;

}
