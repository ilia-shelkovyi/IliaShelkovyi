package hw8.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Errors {

	ERROR_UNKNOWN_WORD(1),
	ERROR_REPEAT_WORD(2),
	ERROR_CAPITALIZATION(3),
	ERROR_TOO_MANY_ERRORS(4);

    private int value;

}
