package ds.graph.bfs;

import ds.graph.Graph;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deep20jain on 09-05-2018.
 */
public class Bipartite extends BFS {
    private int color[];
    private boolean bipartite;

    public Bipartite(Graph graph, int vertices) {
        super(graph, vertices);
        color = new int[vertices];
        Arrays.fill(color, -1);
    }

    public boolean isBipartite() {
        Arrays.fill(color, -1);
        bipartite = true;

        for (int i = 0; i < graph.getNoOfVertices(); i++) {
            if(!discovered[i]) {
                color[i] = 0;
                super.traverse(i);
            }
        }

        return bipartite;
    }

    @Override
    protected void processEdge(int current, int neighbour, List<List<Integer>> edges) {
        super.processEdge(current, neighbour, edges);
        if(color[current] == color[neighbour]) {
            bipartite = false;
        }

        color[neighbour] = complement(color[current]);
    }

    private int complement(int color) {
        if(color == 0)
            return 1;

        if(color == 1)
            return 0;

        return -1;
    }
}
