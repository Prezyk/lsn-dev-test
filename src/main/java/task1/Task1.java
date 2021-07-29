package task1;

import task1.data.DistinctSortedElements;
import task1.process.IntegerListPreparer;
import task1.process.IntegerListProcessor;
import task1.process.exception.IntegerListPrepareException;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1 {
    private static final String WELCOME_MESSAGE = "Please type you integers in proper format (e.g. \"1 2 4 1 3 2 1\")\n";
    private static final String INPUT_SEPARATOR = " ";
    private static final String INVALID_INPUT_MESSAGE = "Error: Input should be integers separated by spaces. Check you input.";

    public static void main(String[] args) {
        printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        try{
            DistinctSortedElements processResult = processInput(userInput);
            printFormattedResult(processResult);
        } catch(IntegerListPrepareException exception) {
            printError();
        }

    }

    private static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    private static DistinctSortedElements processInput(String input) throws IntegerListPrepareException {
        IntegerListProcessor integerProcessor = new IntegerListProcessor();
        List<Integer> integers = prepareInput(input);
        return integerProcessor.processIntegerList(integers);
    }

    private static List<Integer> prepareInput(String input) throws IntegerListPrepareException {
        IntegerListPreparer preparer = new IntegerListPreparer();
        return preparer.prepareIntegersList(input, INPUT_SEPARATOR);
    }

    private static void printFormattedResult(DistinctSortedElements distinctSortedElements) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                String.join(" ", distinctSortedElements
                    .getElements()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.toList()))
                 )
                .append("\ncount: ").append(distinctSortedElements.getElementCount())
                .append("\ndistinct: ").append(distinctSortedElements.getDistinctElementCount())
                .append("\nmin: ").append(distinctSortedElements.getMinValue())
                .append("\nmax: ").append(distinctSortedElements.getMaxValue());
        System.out.println(stringBuilder.toString());
    }

    private static void printError() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

}
