package task1.process;

import org.junit.jupiter.api.Test;
import task1.data.DistinctSortedElements;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListProcessorImplTest {

    private IntegerListProcessor integerListProcessor = new IntegerListProcessorImpl();

    @Test
    void testProcessIntegerListOneElement() {
        List<Integer> input = Arrays.asList(4);
        DistinctSortedElements expectedResult = new DistinctSortedElements(input, 1, 1, 4, 4);
        DistinctSortedElements actualResult = integerListProcessor.processIntegerList(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testProcessIntegerListSameElementDuplicated() {
        List<Integer> input = Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4);
        DistinctSortedElements expectedResult = new DistinctSortedElements(Arrays.asList(4), 16, 1, 4, 4);
        DistinctSortedElements actualResult = integerListProcessor.processIntegerList(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testProcessIntegerListNoDuplicates() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        DistinctSortedElements expectedResult = new DistinctSortedElements(input, 10, 10, 1, 10);
        DistinctSortedElements actualResult = integerListProcessor.processIntegerList(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testProcessIntegerDifferentDuplicates() {
        List<Integer> input = Arrays.asList(1, 4, 1, 2, 4, 5, 12, 14, 22, 32, 17, 21, 22, 21, 25, 27, 28, 8, 9, 13, 2);
        DistinctSortedElements expectedResult = new DistinctSortedElements(Arrays.asList(1, 2, 4, 5, 8, 9, 12, 13, 14, 17, 21, 22, 25, 27, 28, 32), 21, 16, 1, 32);
        DistinctSortedElements actualResult = integerListProcessor.processIntegerList(input);

        assertEquals(expectedResult, actualResult);
    }

}