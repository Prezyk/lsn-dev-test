package task3.process;

import task3.process.exception.ConnectionPrepareException;

public interface ConnectionParser {

    int[][] parseConnections(String[] connectionsRows) throws ConnectionPrepareException;

}
