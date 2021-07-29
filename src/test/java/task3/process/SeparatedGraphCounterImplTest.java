package task3.process;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedGraphCounterImplTest {

    private SeparatedGraphCounter separatedGraphCounter = new SeparatedGraphCounter();

    @Test
    void testCountSeparatedGraphs_1() {
        int expectedNumberOfSeparatedGraphs = 2;
        int[][] edges = new int[][]{
                new int[]{2, 3},
                new int[]{1, 2},
                new int[]{5, 6}
        };
        int actualNumberOfSeparatedGraphs = separatedGraphCounter.countSeparatedGraphs(edges);
        assertEquals(expectedNumberOfSeparatedGraphs, actualNumberOfSeparatedGraphs);
    }

    @Test
    void testCountSeparatedGraphs_2() {
        int expectedNumberOfSeparatedGraphs = 1;
        int[][] edges = new int[][]{
                new int[]{1, 2},
                new int[]{3, 2},
                new int[]{4, 2},
                new int[]{5, 2},
                new int[]{6, 3},
                new int[]{7, 4},
                new int[]{7, 1},
                new int[]{6, 1}
        };
        int actualNumberOfSeparatedGraphs = separatedGraphCounter.countSeparatedGraphs(edges);
        assertEquals(expectedNumberOfSeparatedGraphs, actualNumberOfSeparatedGraphs);
    }

    @Test
    void testCountSeparatedGraphs_3() {
        int expectedNumberOfSeparatedGraphs = 3;
        int[][] edges = new int[][]{
                new int[]{1, 2},
                new int[]{3, 2},
                new int[]{4, 2},
                new int[]{5, 2},
                new int[]{6, 3},
                new int[]{7, 4},
                new int[]{7, 1},
                new int[]{6, 1},
                new int[]{11, 12},
                new int[]{14, 17},
                new int[]{13, 15},
                new int[]{18, 19},
                new int[]{11, 14},
                new int[]{13, 11},
                new int[]{19, 11},
                new int[]{3, 1},
                new int[]{21, 22},
                new int[]{22, 23},
                new int[]{23, 24},
                new int[]{24, 25},
                new int[]{25, 26},
                new int[]{26, 27},
                new int[]{28, 29},
                new int[]{29, 21}
        };
        int actualNumberOfSeparatedGraphs = separatedGraphCounter.countSeparatedGraphs(edges);
        assertEquals(expectedNumberOfSeparatedGraphs, actualNumberOfSeparatedGraphs);
    }

    @Test
    void testCountSeparatedGraphs_4() {
        int expectedNumberOfSeparatedGraphs = 8;
        int[][] edges = new int[][]{
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{5, 6},
                new int[]{7, 8},
                new int[]{9, 10},
                new int[]{11, 12},
                new int[]{13, 14},
                new int[]{15, 16}
        };
        int actualNumberOfSeparatedGraphs = separatedGraphCounter.countSeparatedGraphs(edges);
        assertEquals(expectedNumberOfSeparatedGraphs, actualNumberOfSeparatedGraphs);
    }
}