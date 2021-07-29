package task1.process;

import task1.data.DistinctSortedElements;
import task1.data.DistinctSortedElementsBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerListProcessor {
    public DistinctSortedElements processIntegerList(List<Integer> integerList) {
        DistinctSortedElements distinctSortedElements = null;
        if(integerList != null && integerList.size()>0) {
            List<Integer> integerElements = new ArrayList<>(new HashSet<>(integerList));
            integerElements.sort(Integer::compare);
            distinctSortedElements = createResult(integerElements, integerList.size());
        }
        return distinctSortedElements;
    }

    private DistinctSortedElements createResult(List<Integer> sortedElements, int originalSize) {
        DistinctSortedElements distinctSortedElements = new DistinctSortedElementsBuilder()
                .setElements(sortedElements)
                .setMinValue(sortedElements.get(0))
                .setMaxValue(sortedElements.get(sortedElements.size()-1))
                .setElementCount(originalSize)
                .setDistinctElementCount(sortedElements.size())
                .createDistinctSortedElements();
        return distinctSortedElements;
    }
}
