package standard.impl.ds.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deep20jain on 06-05-2018.
 */
public class GraphTest {

    @Test
    public void testGraphInit_undirected() {
        Graph graph = createUndirectedGraph();

        List<List<Integer>> expected = Arrays.asList(Arrays.asList(0, 1),
                Arrays.asList(1, 5, 2, 0),
                Arrays.asList(2, 4, 3, 1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 2),
                Arrays.asList(5, 4, 1)
        );

        Assert.assertEquals(expected, graph.print());
    }

    @Test
    public void testUndirectedGraph_bfs() {
        Graph graph = createUndirectedGraph();

        List<List<Integer>> expectedEdges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 5),
                Arrays.asList(1, 2),
                Arrays.asList(5, 4),
                Arrays.asList(2, 4),
                Arrays.asList(2, 3)
        );

        List<Integer> expectedVertices = Arrays.asList(0, 1, 5, 2, 4, 3);

        BFS.Traversed traversed = graph.bfs();

        Assert.assertEquals(expectedEdges, traversed.edges);
        Assert.assertEquals(expectedVertices, traversed.vertices);
    }

    /**
     * 0 --- 1 --- 2 --- 3
     *       |     |
     *       5 --- 4
     *
     * @return
     */
    private Graph createUndirectedGraph() {
        Graph graph = new Graph(6, false);
        graph.insertEdge(0, 1, false);
        graph.insertEdge(1, 2, false);
        graph.insertEdge(2, 3, false);
        graph.insertEdge(2, 4, false);
        graph.insertEdge(1, 5, false);
        graph.insertEdge(4, 5, false);
        return graph;
    }
}
