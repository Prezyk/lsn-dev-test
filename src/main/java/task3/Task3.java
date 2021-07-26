package task3;

import task3.process.EdgeParser;
import task3.process.EdgeParserImpl;
import task3.process.SeparatedGraphCounter;
import task3.process.SeparatedGraphCounterImpl;
import task3.process.exception.EdgeParseException;

import java.util.Scanner;

public class Task3 {

    private static final String WELCOME_MESSAGE = "Please type number of edges \"n\" and then edges in the lines below, e.g.:\n3\n1 2\n2 3\n3 4";
    private static final String INVALID_INPUT_MESSAGE = "Error: Wrong format of the data. Check you input.";

    public static void main(String[] args) {
        printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = scanner.nextInt();
        String[] edges = collectInput(scanner, numberOfLines);
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

    private static String[] collectInput(Scanner scanner, int numberOfLines) {
        String[] edges = new String[numberOfLines];
        scanner.nextLine();
        for(int lineIndex=0; lineIndex<numberOfLines; lineIndex++) {
            edges[lineIndex] = scanner.nextLine();
        }
        return edges;
    }

    private static int[][] parseEdges(String[] edges) throws EdgeParseException {
        EdgeParser edgeParser = new EdgeParserImpl();
        return edgeParser.parseEdges(edges);
    }

    private static int countSeparatedGraphs(int[][] edges) {
        SeparatedGraphCounter separatedGraphCounter = new SeparatedGraphCounterImpl();
        int numberOfSeparatedGraphs = separatedGraphCounter.countSeparatedGraphs(edges);
        return numberOfSeparatedGraphs;
    }

    private static void printError() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }


}
