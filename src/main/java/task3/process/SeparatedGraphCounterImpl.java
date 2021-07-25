package task3.process;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeparatedGraphCounterImpl implements SeparatedGraphCounter {
    @Override
    public int countSeparatedGraphs(int[][] verticesConnections) {
        List<Set<Integer>> graphsVertices = new ArrayList<>();
        for(int[] connection: verticesConnections) {
            Integer[] indexesOfConnectedGraphs = new Integer[]{null, null};
            for(int graphIndex=0; graphIndex<graphsVertices.size(); graphIndex++) {
                if(graphsVertices.get(graphIndex).contains(connection[0]) || graphsVertices.get(graphIndex).contains(connection[1])) {
                    if(indexesOfConnectedGraphs[0]==null) {
                        indexesOfConnectedGraphs[0] = graphIndex;
                    } else {
                        indexesOfConnectedGraphs[1] = graphIndex;
                    }
                }
            }

            if(indexesOfConnectedGraphs[0]==null) {
                Set<Integer> graphStarter = new HashSet<>();
                graphStarter.add(connection[0]);
                graphStarter.add(connection[1]);
                graphsVertices.add(graphStarter);
            } else if(indexesOfConnectedGraphs[0]!=null && indexesOfConnectedGraphs[1]==null) {
                graphsVertices.get(indexesOfConnectedGraphs[0]).add(connection[0]);
                graphsVertices.get(indexesOfConnectedGraphs[0]).add(connection[1]);
            } else if(indexesOfConnectedGraphs[0]!=null && indexesOfConnectedGraphs[1]!=null) {
                Set<Integer> graphToMerge = graphsVertices.get(indexesOfConnectedGraphs[0]);
                graphsVertices.remove(indexesOfConnectedGraphs[0]);
                graphsVertices.get(indexesOfConnectedGraphs[1]).addAll(graphToMerge);
            }

        }
        return graphsVertices.size();
    }
}
