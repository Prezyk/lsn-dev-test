package task1.process;

import task1.process.exception.IntegerListPrepareException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerListPreparerImpl implements IntegerListPreparer{
    @Override
    public List<Integer> prepareIntegersList(String integers, String separator) throws IntegerListPrepareException {
        String[] splitIntegers = integers.split(" ");
        try {
            List<Integer> preparedIntegers = Arrays.stream(splitIntegers)
                    .map(Integer::new)
                    .collect(Collectors.toList());
            return preparedIntegers;

        } catch(NumberFormatException e) {
            throw new IntegerListPrepareException(e);
        }
    }
}
