package hw8.enums;

import lombok.Getter;

@Getter
public enum Options {

	IGNORE_DIGITS(2),
	IGNORE_URLS(4),
	FIND_REPEAT_WORDS(8),
	IGNORE_CAPITALIZATION(512);

    private int value;

    Options(int value) {
        this.value = value;
    }

}
