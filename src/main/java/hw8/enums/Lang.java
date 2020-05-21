package hw8.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Lang {

    RU("ru"),
    UK("uk"),
    EN("en");

    private String value;

}
