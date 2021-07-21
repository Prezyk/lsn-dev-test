package task2;

import task1.process.IntegerListPreparer;
import task1.process.IntegerListPreparerImpl;
import task1.process.exception.IntegerListPrepareException;
import task2.process.PairFinder;
import task2.process.PairFinderImp;

import java.util.List;
import java.util.Scanner;

public class Task2 {

    private static final String WELCOME_MESSAGE = "Please type you integers in proper format (e.g. \"1 2 4 1 3 2 1\")\n";
    private static final String INPUT_SEPARATOR = " ";
    private static final String INVALID_INPUT_MESSAGE = "Error: Input should be integers separated by spaces. Check you input.";
    private static final int SUM_UP_TO = 13;

    public static void main(String[] args) {
        printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        try {
            List<Integer[]> processResult = processInput(userInput);
            printFormattedResult(processResult);
        } catch (IntegerListPrepareException exception) {
            printError();
        }
    }

    private static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    private static List<Integer[]> processInput(String input) throws IntegerListPrepareException {
        PairFinder pairFinder = new PairFinderImp(SUM_UP_TO);
        List<Integer> integers = prepareInput(input);
        return pairFinder.findPairs(integers);
    }

    private static List<Integer> prepareInput(String input) throws IntegerListPrepareException {
        IntegerListPreparer preparer = new IntegerListPreparerImpl();
        return preparer.prepareIntegersList(input, INPUT_SEPARATOR);
    }

    private static void printFormattedResult(List<Integer[]> integerPairs) {
        integerPairs.forEach(Task2::printPair);
    }

    private static void printPair(Integer[] integerPair) {
        System.out.println(integerPair[0] + " " + integerPair[1] + "\n");
    }

    private static void printError() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }


}
