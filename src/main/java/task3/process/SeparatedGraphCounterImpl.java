package task3.process;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeparatedGraphCounterImpl implements SeparatedGraphCounter {
    @Override
    public int countSeparatedGraphs(int[][] edgesVertices) {
        List<Set<Integer>> graphsVertices = new ArrayList<>();
        for(int[] edgeVertices: edgesVertices) {
            addEdgeVerticesToGraphsVertices(graphsVertices, edgeVertices);
        }
        return graphsVertices.size();
    }

    private Integer[] findIndexesOfGraphsConnectedToEdge(List<Set<Integer>> graphsVertices, int[] edge) {
        Integer[] indexesOfConnectedGraphs = new Integer[]{null, null};
        for(int graphIndex=0; graphIndex<graphsVertices.size(); graphIndex++) {
            if(graphsVertices.get(graphIndex).contains(edge[0]) || graphsVertices.get(graphIndex).contains(edge[1])) {
                if(indexesOfConnectedGraphs[0]==null) {
                    indexesOfConnectedGraphs[0] = graphIndex;
                } else {
                    indexesOfConnectedGraphs[1] = graphIndex;
                }
            }
        }
        return indexesOfConnectedGraphs;
    }

    private void addEdgeVerticesToGraphsVertices(List<Set<Integer>> graphsVertices, int[] edgeVertices) {
        Integer[] indexesOfConnectedGraphs = findIndexesOfGraphsConnectedToEdge(graphsVertices, edgeVertices);

        if(separatedEdge(indexesOfConnectedGraphs)) {
            addNewGraphVertices(graphsVertices, edgeVertices);
        } else if(edgeConnectedToOneGraph(indexesOfConnectedGraphs)) {
            addVerticesToExistingGraph(graphsVertices.get(indexesOfConnectedGraphs[0]), edgeVertices);
        } else if(edgeConnectingTwoGraphs(indexesOfConnectedGraphs)) {
            mergeTwoGraphs(graphsVertices, indexesOfConnectedGraphs);
        }
    }

    private boolean separatedEdge(Integer[] indexesOfConnectedGraphs) {
        return indexesOfConnectedGraphs[0]==null;
    }

    private void addNewGraphVertices(List<Set<Integer>> graphsVertices, int[] edgeVertices) {
        Set<Integer> graphStarter = new HashSet<>();
        graphStarter.add(edgeVertices[0]);
        graphStarter.add(edgeVertices[1]);
        graphsVertices.add(graphStarter);
    }

    private boolean edgeConnectedToOneGraph(Integer[] indexesOfConnectedGraphs) {
        return indexesOfConnectedGraphs[0]!=null && indexesOfConnectedGraphs[1]==null;
    }

    private void addVerticesToExistingGraph(Set<Integer> graphVertices, int[] edgeVertices) {
        graphVertices.add(edgeVertices[0]);
        graphVertices.add(edgeVertices[1]);
    }

    private boolean edgeConnectingTwoGraphs(Integer[] indexesOfConnectedGraphs) {
        return indexesOfConnectedGraphs[0]!=null && indexesOfConnectedGraphs[1]!=null;
    }

    private void mergeTwoGraphs(List<Set<Integer>> graphsVertices, Integer[] indexesOfConnectedGraphs) {
        Set<Integer> graphToMerge = graphsVertices.get(indexesOfConnectedGraphs[0]);
        graphsVertices.remove(indexesOfConnectedGraphs[0]);
        graphsVertices.get(indexesOfConnectedGraphs[1]).addAll(graphToMerge);
    }
}
