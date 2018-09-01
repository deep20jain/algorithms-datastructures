package ds.graph;

/**
 * Created by deep20jain on 12-05-2018.
 */
public class GraphTestBase {
    /**
     * 0 --- 1 --- 2 --- 3
     *       |     |
     *       5 --- 4
     *
     * @return
     */
    protected Graph createUndirectedGraph() {
        Graph graph = new Graph(6, false);
        graph.insertEdge(0, 1, false);
        graph.insertEdge(1, 2, false);
        graph.insertEdge(2, 3, false);
        graph.insertEdge(2, 4, false);
        graph.insertEdge(1, 5, false);
        graph.insertEdge(4, 5, false);
        return graph;
    }

    /**
     * 0 --- 1   2   3
     *       |   |   |
     *       5   4   6
     *
     * @return
     */
    protected Graph createUndirectedGraph_disconnected() {
        Graph graph = new Graph(7, false);
        graph.insertEdge(0, 1, false);
        graph.insertEdge(2, 4, false);
        graph.insertEdge(1, 5, false);
        graph.insertEdge(3, 6, false);
        return graph;
    }


    /**
     * 0 --- 1 --- 2 --- 3
     *       |  \  |
     *       5 --- 4
     *
     * @return
     */
    protected Graph createUndirectedGraph_nonBipartite() {
        Graph graph = new Graph(6, false);
        graph.insertEdge(0, 1, false);
        graph.insertEdge(1, 2, false);
        graph.insertEdge(2, 3, false);
        graph.insertEdge(2, 4, false);
        graph.insertEdge(1, 5, false);
        graph.insertEdge(4, 5, false);
        graph.insertEdge(1, 4, false);
        return graph;
    }

}
