package task3.process;

import org.junit.jupiter.api.Test;
import task3.process.exception.EdgeParseException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EdgeParserImplTest {

    private EdgeParser edgeParser = new EdgeParser();


    @Test
    void testParseConnectionsThreeNumbersInRow() {
        String[] edgesToParse = new String[]{"1 2 3", "2 3 4", "3 4 5", "4 5 6", "1 4 6"};
        assertThrows(EdgeParseException.class, () -> {
            edgeParser.parseEdges(edgesToParse);
        });
    }

    @Test
    void testParserConnectionsNonDigitsCharsInRows() {
        String[] edgesToParse = new String[]{"1 a", "c 3", "3 4", "q 5", "q 1"};
        assertThrows(EdgeParseException.class, () -> {
            edgeParser.parseEdges(edgesToParse);
        });
    }

    @Test
    void testParserConnections() throws EdgeParseException {
        String[] connectionsToParse = new String[]{"1 2", "2 3", "3 4", "4 5", "5 1"};
        int[][] expectedParsedConnections = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 1}};
        int[][] actualParsedConnections = edgeParser.parseEdges(connectionsToParse);
        assertArrayEquals(expectedParsedConnections, actualParsedConnections);
    }

}