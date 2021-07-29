package task3.process;

import java.util.*;

public class SeparatedGraphCounter {

    public int countSeparatedGraphs(int[][] edgesVertices) {
        Map<Integer, Set<Integer>> adjacencyList = createAdjacencyList(edgesVertices);
        int graphCount = 0;
        while(!adjacencyList.keySet().isEmpty()) {
            Integer nextKey = (Integer)adjacencyList.keySet().toArray()[0];
            removeGraphContinuation(nextKey, adjacencyList, new HashSet<>());
            graphCount++;
        }
        return graphCount;
    }

    private void removeGraphContinuation(int indexKey, Map<Integer, Set<Integer>> adjacencyList, Set<Integer> seen) {
        seen.add(indexKey);
        Set<Integer> currentAdjacencyNode = adjacencyList.remove(indexKey);
        for(Integer nextKey: currentAdjacencyNode) {
            if(!seen.contains(nextKey)) {
                removeGraphContinuation(nextKey, adjacencyList, seen);
            }
        }
    }

    private Map<Integer, Set<Integer>> createAdjacencyList(int[][] edges) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for(int[] edge: edges) {
            addAdjacencyListEntry(edge[0], edge[1], adjacencyList);
            addAdjacencyListEntry(edge[1], edge[0], adjacencyList);
        }
        return adjacencyList;
    }

    private void addAdjacencyListEntry(int key, int value, Map<Integer, Set<Integer>> adjacencyList) {
        if(adjacencyList.get(key)==null) {
            adjacencyList.put(key, new HashSet<Integer>(){{add(value);}});
        } else {
            adjacencyList.get(key).add(value);
        }
    }
}
