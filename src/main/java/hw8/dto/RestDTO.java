package hw8.dto;

import lombok.Data;

@Data
public class RestDTO {

    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private String[] s;

}
