package ds.graph.bfs;

import ds.graph.Graph;
import ds.graph.GraphTestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deep20jain on 12-05-2018.
 */
public class BFSTest extends GraphTestBase {
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

    @Test
    public void testUndirectedGraph_bfs_findpath() {
        Graph graph = createUndirectedGraph();

        List<Integer> expected = Arrays.asList(1, 5, 4);

        BFS bfs = new BFS(graph, graph.getNoOfVertices());
        bfs.traverse(1);

        List<Integer> res = new ArrayList<>();
        bfs.findPath(1, 4, bfs.parent, res);
        Assert.assertEquals(expected, res);
    }

    @Test
    public void testUndirectedGraph_connectedComponents_givenOneComponent() {
        Graph graph = createUndirectedGraph();
        BFS bfs = new BFS(graph, graph.getNoOfVertices());

        Assert.assertEquals(1, bfs.findConnectedComponents());
    }

    @Test
    public void testUndirectedGraph_connectedComponents_givenMultipleComponents() {
        Graph graph = createUndirectedGraph_disconnected();
        BFS bfs = new BFS(graph, graph.getNoOfVertices());

        Assert.assertEquals(3, bfs.findConnectedComponents());
    }

    @Test
    public void testUndirectedGraph_bipartite() {
        Graph graph = createUndirectedGraph();
        Bipartite bipartite = new Bipartite(graph, graph.getNoOfVertices());

        Assert.assertTrue(bipartite.isBipartite());
    }

    @Test
    public void testUndirectedGraph_nonbipartite() {
        Graph graph = createUndirectedGraph_nonBipartite();
        Bipartite bipartite = new Bipartite(graph, graph.getNoOfVertices());

        Assert.assertFalse(bipartite.isBipartite());
    }
}
