package hw8.enums;

import lombok.Getter;

@Getter
public enum Lang {

    RU("ru"),
    UK("uk"),
    EN("en");

    private String value;

    Lang(String value) {
        this.value = value;
    }

}
