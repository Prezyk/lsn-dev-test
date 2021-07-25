package task3.process;

import task3.process.exception.ConnectionParseException;

public class ConnectionParserImpl implements ConnectionParser {

    private static final String VERTICES_SEPARATOR = " ";
    private static final String INVALID_ELEMENT_COUNT_MESSAGE = "Invalid vertices count at row: %d";
    private static final String INVALID_CHAR_AT_CONNECTION_ROW = "Invalid vertex char at row: %d";

    @Override
    public int[][] parseConnections(String[] connectionsRows) throws ConnectionParseException {
        int[][] connections = new int[connectionsRows.length][];
        for(int rowIndex=0; rowIndex<connectionsRows.length; rowIndex++) {
            connections[rowIndex] = parseConnectionRow(connectionsRows[rowIndex], rowIndex);
        }
        return connections;
    }


    private int[] parseConnectionRow(String connectionRow, int rowIndex) throws ConnectionParseException {
        String[] connectionRowElements = connectionRow.split(VERTICES_SEPARATOR);
        if(connectionRowElements.length!=2) {
            throw new ConnectionParseException(String.format(INVALID_ELEMENT_COUNT_MESSAGE, rowIndex));
        }
        int[] connectionVertices = new int[2];
        for(int elementIndex=0; elementIndex<connectionRowElements.length; elementIndex++) {
            try {
                connectionVertices[elementIndex] = Integer.parseInt(connectionRowElements[elementIndex]);
            } catch (NumberFormatException numberFormatException) {
                throw new ConnectionParseException(String.format(INVALID_CHAR_AT_CONNECTION_ROW, rowIndex), numberFormatException);
            }
        }
        return connectionVertices;
    }

}
