package task2.process;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderImpTest {

    private PairFinder pairFinder = new PairFinder(13);


    @Test
    void testFindPairsPairsPresentInList() {
        List<Integer> input = new ArrayList<Integer>(){{
                add(1);
                add(2);
                add(10);
                add(7);
                add(5);
                add(3);
                add(6);
                add(6);
                add(13);
                add(0);
                add(7);
            }};
        List<Integer[]> expectedPairs = Arrays.asList(
                new Integer[]{0, 13},
                new Integer[]{3, 10},
                new Integer[]{6, 7},
                new Integer[]{6, 7}
                );
        List<Integer[]> actualPairs = pairFinder.findPairs(input);
        for(int index = 0; index<expectedPairs.size(); index++) {
            assertArrayEquals(expectedPairs.get(index), actualPairs.get(index));
        }
    }

    @Test
    void testFindPairsPairsNotPresentInList() {
        List<Integer> input = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(1);
            add(2);
            add(2);
            add(2);
            add(1);
            add(3);
            add(4);
            add(5);
        }};
        List<Integer[]> expectedPairs = new ArrayList<>();
        List<Integer[]> actualPairs = pairFinder.findPairs(input);
        assertEquals(expectedPairs, actualPairs);
    }

    @Test
    void testFindPairsOnlyPairsPresent() {
        List<Integer> input = new ArrayList<Integer>(){{
            add(4);
            add(9);
            add(3);
            add(10);
            add(1);
            add(12);
            add(2);
            add(11);
            add(5);
            add(8);
            add(9);
            add(4);
            add(6);
            add(7);
        }};
        List<Integer[]> expectedPairs = Arrays.asList(
                new Integer[]{1, 12},
                new Integer[]{2, 11},
                new Integer[]{3, 10},
                new Integer[]{4, 9},
                new Integer[]{4, 9},
                new Integer[]{5, 8},
                new Integer[]{6, 7}
        );
        List<Integer[]> actualPairs = pairFinder.findPairs(input);
        for(int i=0; i<actualPairs.size(); i++) {
            assertArrayEquals(expectedPairs.get(i), actualPairs.get(i));
        }
    }

}