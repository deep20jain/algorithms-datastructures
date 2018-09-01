package ds.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deep20jain on 06-05-2018.
 */
public class GraphTest extends GraphTestBase {

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
}
