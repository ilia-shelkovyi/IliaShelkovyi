package hw7.enities;

import static java.util.Arrays.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetalsColorsData {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    @Override
    public String toString() {
        return String.format("Summary: %s\nElements: %s\nColor: %s\nMetal: %s\nVegetables: %s",
        		stream(summary).sum(), String.join(", ", elements), color, metals, String.join(", ", vegetables));
    }

}