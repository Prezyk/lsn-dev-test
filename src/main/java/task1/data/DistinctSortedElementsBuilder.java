package task1.data;

import java.util.List;

public class DistinctSortedElementsBuilder {
    private List<Integer> elements;
    private int elementCount;
    private int distinctElementCount;
    private int minValue;
    private int maxValue;

    public DistinctSortedElementsBuilder setElements(List<Integer> elements) {
        this.elements = elements;
        return this;
    }

    public DistinctSortedElementsBuilder setElementCount(int elementCount) {
        this.elementCount = elementCount;
        return this;
    }

    public DistinctSortedElementsBuilder setDistinctElementCount(int distinctElementCount) {
        this.distinctElementCount = distinctElementCount;
        return this;
    }

    public DistinctSortedElementsBuilder setMinValue(int minValue) {
        this.minValue = minValue;
        return this;
    }

    public DistinctSortedElementsBuilder setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public DistinctSortedElements createDistinctSortedElements() {
        return new DistinctSortedElements(elements, elementCount, distinctElementCount, minValue, maxValue);
    }
}