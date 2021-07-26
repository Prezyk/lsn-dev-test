package task3.process;

import task3.process.exception.EdgeParseException;

public interface EdgeParser {

    int[][] parseEdges(String[] edges) throws EdgeParseException;

}
