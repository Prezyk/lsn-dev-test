package task1.data;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistinctSortedElements that = (DistinctSortedElements) o;
        return elementCount == that.elementCount && distinctElementCount == that.distinctElementCount && minValue == that.minValue && maxValue == that.maxValue && Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, elementCount, distinctElementCount, minValue, maxValue);
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
