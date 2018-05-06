package standard.impl.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by deep20jain on 06-05-2018.
 */
public class BFS {
    boolean processed[];
    boolean discovered[];
    int parent[];

    public BFS(int vertices) {
        processed = new boolean[vertices];
        discovered = new boolean[vertices];
        parent = new int[vertices];
    }

    public Traversed traverse(Graph graph, int start) {
        List<Integer> vertices = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        discovered[start] = true;

        int current, neighbour;
        Graph.EdgeNode edge;

        while (!queue.isEmpty()) {
            current = queue.poll();
            processVertexEarly(current, vertices);
            processed[current] = true;

            edge = graph.edges[current];

            while (edge!=null) {
                neighbour = edge.y;

                if(!processed[neighbour] || graph.directed) {
                    processEdge(current, neighbour, edges);
                }

                if(!discovered[neighbour]) {
                    queue.add(neighbour);
                    discovered[neighbour] = true;
                    parent[neighbour] = current;
                }

                edge = edge.next;
            }
            processVertexLate(current, vertices);
        }

        return new Traversed(vertices, edges);
    }


    private void processVertexEarly(int current, List<Integer> vertices) {
        vertices.add(current);
        System.out.println(String.format("Vertex - %d", current));
    }

    private void processEdge(int current, int neighbour, List<List<Integer>> edges) {
        List<Integer> edge = new ArrayList<>();
        edge.add(current);
        edge.add(neighbour);
        edges.add(edge);
        System.out.println(String.format("Edge - %d %d", current, neighbour));
    }

    private void processVertexLate(int current, List<Integer> vertices) {
        //do nothing
    }

    public class Traversed {
        List<Integer> vertices;
        List<List<Integer>> edges;

        public Traversed(List<Integer> vertices, List<List<Integer>> edges) {
            this.vertices = vertices;
            this.edges = edges;
        }
    }
}
