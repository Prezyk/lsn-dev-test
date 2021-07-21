package task2.process;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PairFinderImp implements PairFinder {

    private int sumUpTo;

    public PairFinderImp(int sumUpTo) {
        this.sumUpTo = sumUpTo;
    }

    @Override
    public List<Integer[]> findPairs(List<Integer> integers) {
        integers.sort(Integer::compare);
        List<Integer[]> integerPairs = new ArrayList<>();
        for(int index=0; index<integers.size(); index++) {
            Integer integerToPair = integers.get(index);
            if(integerToPair==null) {
                continue;
            }
            Integer pairedInteger = findPairForInteger(integerToPair, integers);
            if(pairedInteger!=null) {
                integers.set(index, null);
                integerPairs.add(new Integer[]{integerToPair, pairedInteger});
            }
        }
        return integerPairs;
    }

    private Integer findPairForInteger(Integer integerToPair, List<Integer> integers) {
        Integer pairedInteger = null;
        int index=integers.size()-1;
        for(; index>=0; index--) {
            if(integers.get(index)==null) {
                continue;
            }
            int pairSum = integers.get(index) + integerToPair;
            if(pairSum == sumUpTo) {
                pairedInteger = integers.get(index);
                break;
            }
        }
        if(pairedInteger!=null) {
            integers.set(index, null);
        }
        return pairedInteger;
    }
}
