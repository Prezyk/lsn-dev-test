package task3.process;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedGraphCounterImplTest {

    private SeparatedGraphCounter separatedGraphCounter = new SeparatedGraphCounterImpl();

    @Test
    void testCountSeparatedGraphs() {
        int expectedNumberOfSeparatedGraphs = 2;
        int[][] edges = new int[][]{
                new int[]{2, 3},
                new int[]{1, 2},
                new int[]{5, 6}
        };
        int actualNumberOfSeparatedGraphs = separatedGraphCounter.countSeparatedGraphs(edges);
        assertEquals(expectedNumberOfSeparatedGraphs, actualNumberOfSeparatedGraphs);
    }

}