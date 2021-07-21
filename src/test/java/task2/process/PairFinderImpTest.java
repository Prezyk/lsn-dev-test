package task2.process;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderImpTest {

    private PairFinder pairFinder = new PairFinderImp(13);


    @Test
    void testFindPairsPairsPresentInList() {
        List<Integer> input = Arrays.asList(1,2,10,7,5,3,6,6,13,0,7);
        List<Integer[]> expectedPairs = Arrays.asList(
                new Integer[]{0, 13},
                new Integer[]{3, 10},
                new Integer[]{6, 7},
                new Integer[]{6, 7}
                );
        List<Integer[]> actualPairs = pairFinder.findPairs(input);
        for(int index = 0; index<expectedPairs.size(); index++) {
            assertEquals(expectedPairs.get(index)[0], actualPairs.get(index)[0]);
            assertEquals(expectedPairs.get(index)[1], actualPairs.get(index)[1]);
        }
    }

    @Test
    void testFindPairsPairsNotPresentInList() {
        List<Integer> input = Arrays.asList(1, 2, 3, 1, 2, 2, 2, 1, 3, 4, 5);
        List<Integer[]> expectedPairs = new ArrayList<>();
        List<Integer[]> actualPairs = pairFinder.findPairs(input);
        assertEquals(expectedPairs, actualPairs);
    }

}