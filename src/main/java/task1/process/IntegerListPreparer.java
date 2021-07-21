package task1.process;

import task1.process.exception.IntegerListPrepareException;

import java.util.List;

public interface IntegerListPreparer {
    List<Integer> prepareIntegersList(String integers, String separator) throws IntegerListPrepareException;
}
