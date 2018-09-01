package ds.graph.dfs;

import ds.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deep20jain on 13-05-2018.
 */
public class DFSDetectCycle extends DFS {
    boolean isCycleDetected;

    public DFSDetectCycle(Graph g) {
        super(g);
    }

    @Override
    protected void processEdge(int current, int neighbour, List<List<Integer>> edges) {
        if(discovered[neighbour] && parent[current] != neighbour) {
            System.out.println(String.format("Cycle detected from %s to %s", neighbour, current));
            findPath(neighbour, current, parent, new ArrayList<>());
            finished = true;
            isCycleDetected = true;
        }
    }

    public boolean isCycleDetected() {
        return isCycleDetected;
    }
}
