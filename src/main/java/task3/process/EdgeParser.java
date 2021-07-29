package task3.process;

import task3.process.exception.EdgeParseException;

public class EdgeParser {

    private static final String VERTICES_SEPARATOR = " ";
    private static final String INVALID_VERTEX_COUNT_MESSAGE = "Invalid vertices count at edge index: %d";
    private static final String INVALID_VERTEX_CHAR = "Invalid vertex char at edge index: %d";

    public int[][] parseEdges(String[] edges) throws EdgeParseException {
        int[][] parsedEdges = new int[edges.length][];
        for(int edgeIndex=0; edgeIndex<edges.length; edgeIndex++) {
            parsedEdges[edgeIndex] = parseEdge(edges[edgeIndex], edgeIndex);
        }
        return parsedEdges;
    }


    private int[] parseEdge(String edge, int edgeIndex) throws EdgeParseException {
        String[] edgeVertices = edge.split(VERTICES_SEPARATOR);
        validateEdgeVerticesNumber(edgeVertices, edgeIndex);
        int[] parsedEdgeVertices = new int[2];
        for(int vartexIndex=0; vartexIndex<edgeVertices.length; vartexIndex++) {
            parsedEdgeVertices[vartexIndex] = parseVertexFromEdge(edgeVertices[vartexIndex], edgeIndex);
        }
        return parsedEdgeVertices;
    }

    private void validateEdgeVerticesNumber(String[] edgeVertices, int edgeIndex) throws EdgeParseException {
        if(edgeVertices.length!=2) {
            throw new EdgeParseException(String.format(INVALID_VERTEX_COUNT_MESSAGE, edgeIndex));
        }
    }

    private int parseVertexFromEdge(String vertexToParse, int edgeIndex) throws EdgeParseException {
        try {
            int parsedVertex = Integer.parseInt(vertexToParse);
            return parsedVertex;
        } catch (NumberFormatException numberFormatException) {
            throw new EdgeParseException(String.format(INVALID_VERTEX_CHAR, edgeIndex), numberFormatException);
        }
    }

}
