package task3.process;

import task3.process.exception.ConnectionPrepareException;

public interface ConnectionPreparer {

    int[][] prepareConnections(String[] connectionsRows) throws ConnectionPrepareException;

}
