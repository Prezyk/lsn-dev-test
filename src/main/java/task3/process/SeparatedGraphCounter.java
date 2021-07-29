package task3.process;

import java.util.*;

public class SeparatedGraphCounter {

    public int countSeparatedGraphs(int[][] edgesVertices) {
        Map<Integer, Set<Integer>> adjacencyList = createAdjacencyList(edgesVertices);
        int graphCount = 0;
        while(!adjacencyList.keySet().isEmpty()) {
            Integer nextKey = adjacencyList.keySet().iterator().next();
            removeGraphContinuation(nextKey, adjacencyList, new HashSet<>());
            graphCount++;
        }
        return graphCount;
    }

    private Map<Integer, Set<Integer>> createAdjacencyList(int[][] edges) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for(int[] edge: edges) {
            addAdjacencyListEntry(edge[0], edge[1], adjacencyList);
            addAdjacencyListEntry(edge[1], edge[0], adjacencyList);
        }
        return adjacencyList;
    }

    private void addAdjacencyListEntry(int vertexKey, int vertexAdjacency, Map<Integer, Set<Integer>> adjacencyList) {
        if(adjacencyList.get(vertexKey)==null) {
            adjacencyList.put(vertexKey, new HashSet<Integer>(){{add(vertexAdjacency);}});
        } else {
            adjacencyList.get(vertexKey).add(vertexAdjacency);
        }
    }

    private void removeGraphContinuation(int indexKey, Map<Integer, Set<Integer>> adjacencyList, Set<Integer> visitedVertices) {
        visitedVertices.add(indexKey);
        Set<Integer> currentAdjacencyNode = adjacencyList.remove(indexKey);
        for(Integer nextKey: currentAdjacencyNode) {
            if(!visitedVertices.contains(nextKey)) {
                removeGraphContinuation(nextKey, adjacencyList, visitedVertices);
            }
        }
    }
}
