package task1.data;

import java.util.List;

public class DistinctSortedElements {

    private List<Integer> elements;
    private int elementCount;
    private int distinctElementCount;
    private int minValue;
    private int maxValue;

    public DistinctSortedElements(List<Integer> elements, int elementCount, int distinctElementCount, int minValue, int maxValue) {
        this.elements = elements;
        this.elementCount = elementCount;
        this.distinctElementCount = distinctElementCount;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public List<Integer> getElements() {
        return elements;
    }

    public void setElements(List<Integer> elements) {
        this.elements = elements;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

    public int getDistinctElementCount() {
        return distinctElementCount;
    }

    public void setDistinctElementCount(int distinctElementCount) {
        this.distinctElementCount = distinctElementCount;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
