package hw8.dto;

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

}