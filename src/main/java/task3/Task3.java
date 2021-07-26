package task3;

import task3.process.exception.EdgeParseException;

import java.util.Scanner;

public class Task3 {

    private static final String WELCOME_MESSAGE = "Please type number of edges \"n\" and then edges in the lines below, e.g.:\n3\n1 2\n2 3\n3 4";
    private static final String INVALID_INPUT_MESSAGE = "Error: Wrong format of the data. Check you input.";

    public static void main(String[] args) {
        printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = scanner.nextInt();
        String[] edges = collectInput(numberOfLines);
        try {
            int[][] parsedEdges = parseEdges(edges);
            int numberOfSeparatedGraphs = countSeparatedGraphs(parsedEdges);
            System.out.println(numberOfSeparatedGraphs);
        } catch (EdgeParseException exception) {
            printError();
        }
    }

    private static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    private static String[] collectInput(int numberOfLines) {
        return null;
    }

    private static int[][] parseEdges(String[] edges) throws EdgeParseException {
        return null;
    }

    private static int countSeparatedGraphs(int[][] connections) {
        return -1;
    }

    private static void printError() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }


}
