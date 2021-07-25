package task3;

import task3.process.exception.ConnectionParseException;

import java.util.Scanner;

public class Task3 {

    private static final String WELCOME_MESSAGE = "Please type number of connections \"n\" and then connections in the lines below, e.g.:\n3\n1 2\n2 3\n3 4";
    private static final String INVALID_INPUT_MESSAGE = "Error: Wrong format of the data. Check you input.";

    public static void main(String[] args) {
        printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = scanner.nextInt();
        String[] connectionsRows = collectInput(numberOfLines);
        try {
            int[][] connections = parseConnections(connectionsRows);
            int numberOfSeparatedGraphs = countSeparatedGraphs(connections);
            System.out.println(numberOfSeparatedGraphs);
        } catch (ConnectionParseException exception) {
            printError();
        }
    }

    private static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    private static String[] collectInput(int numberOfLines) {
        return null;
    }

    private static int[][] parseConnections(String[] connectionsRows) throws ConnectionParseException {
        return null;
    }

    private static int countSeparatedGraphs(int[][] connections) {
        return -1;
    }

    private static void printError() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }


}
