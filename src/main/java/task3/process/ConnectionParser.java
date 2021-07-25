package task3.process;

import task3.process.exception.ConnectionParseException;

public interface ConnectionParser {

    int[][] parseConnections(String[] connectionsRows) throws ConnectionParseException;

}
