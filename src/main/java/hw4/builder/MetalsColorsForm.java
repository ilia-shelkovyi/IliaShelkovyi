package hw4.builder;

import java.util.List;

public class MetalsColorsForm {

    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;

    private MetalsColorsForm(List<String> summary, List<String> elements, String color, String metal, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<String> summary;
        private List<String> elements;
        private String color;
        private String metal;
        private List<String> vegetables;

        Builder() {}

        public Builder setSummary(List<String> summary) {
            this.summary = summary;
            return this;
        }

        public Builder setElements(List<String> elements) {
            this.elements = elements;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMetal(String metal) {
            this.metal = metal;
            return this;
        }

        public Builder setVegetables(List<String> vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public MetalsColorsForm build() {
            return new MetalsColorsForm(summary, elements, color, metal, vegetables);
        }
    }
}