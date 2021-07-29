package task2.process;

import com.sun.javafx.image.IntPixelGetter;
import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.List;

public class PairFinder {

    private int sumUpTo;

    public PairFinder(int sumUpTo) {
        this.sumUpTo = sumUpTo;
    }

    public List<Integer[]> findPairs(List<Integer> integers) {
        integers.sort(Integer::compare);
        List<Integer[]> integerPairs = new ArrayList<>();
        int[] indexes = new int[]{0, integers.size()-1};

        while(indexes[0]<indexes[1]) {
            int currentSum = integers.get(indexes[0]) + integers.get(indexes[1]);
            if(currentSum==sumUpTo) {
                integerPairs.add(new Integer[]{integers.get(indexes[0]), integers.get(indexes[1])});
            }
            indexes = updateIndexes(indexes, currentSum);
        }
        return integerPairs;
    }

    private int[] updateIndexes(int[] indexesToUpdate, int currentSum) {
        if(currentSum==sumUpTo) {
            indexesToUpdate[0]++;
            indexesToUpdate[1]--;
        } else if(currentSum<sumUpTo) {
            indexesToUpdate[0]++;
        } else if(currentSum>sumUpTo) {
            indexesToUpdate[1]--;
        }
        return indexesToUpdate;
    }
}
