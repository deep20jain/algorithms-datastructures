package ds.graph.dfs;

import ds.graph.Graph;
import ds.graph.GraphTestBase;
import ds.graph.dfs.DFS;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deep20jain on 12-05-2018.
 */
public class DFSTest extends GraphTestBase {
    @Test
    public void testUndirectedGraph_dfs() {
        Graph graph = createUndirectedGraph();

        List<List<Integer>> expectedEdges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 5),
                Arrays.asList(1, 2),
                Arrays.asList(5, 4),
                Arrays.asList(2, 4),
                Arrays.asList(2, 3)
        );

        List<Integer> expectedVertices = Arrays.asList(0, 1, 5, 4, 2, 3);

        DFS.Traversed traversed = graph.dfs();

        //Assert.assertEquals(expectedEdges, traversed.edges);
        Assert.assertEquals(expectedVertices, traversed.vertices);
    }

    @Test
    public void testUndirectedGraph_dfs_detectCycle() {
        Graph graph = createUndirectedGraph();
        DFSDetectCycle dfs = new DFSDetectCycle(graph);

        dfs.traverse(0);
        Assert.assertTrue(dfs.isCycleDetected());
    }

    @Test
    public void testUndirectedGraph_dfs_multipleCycles_detectCycle() {
        Graph graph = createUndirectedGraph_nonBipartite();
        DFSDetectCycle dfs = new DFSDetectCycle(graph);

        dfs.traverse(0);
        Assert.assertTrue(dfs.isCycleDetected());
    }
}
