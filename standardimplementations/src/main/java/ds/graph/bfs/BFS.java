package ds.graph.bfs;

import ds.graph.Graph;

import java.util.*;

/**
 * Created by deep20jain on 06-05-2018.
 */
public class BFS {
    boolean[] processed;
    boolean[] discovered;
    int[] parent;
    Graph graph;

    public BFS(Graph graph, int vertices) {
        processed = new boolean[vertices];
        discovered = new boolean[vertices];
        parent = new int[vertices];
        this.graph = graph;
    }

    public Traversed traverse(int start) {
        Arrays.fill(parent, -1);
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

            edge = graph.getEdges()[current];

            while (edge!=null) {
                neighbour = edge.getY();

                if(!processed[neighbour] || graph.isDirected()) {
                    processEdge(current, neighbour, edges);
                }

                if(!discovered[neighbour]) {
                    queue.add(neighbour);
                    discovered[neighbour] = true;
                    parent[neighbour] = current;
                }

                edge = edge.getNext();
            }
            processVertexLate(current, vertices);
        }

        return new Traversed(vertices, edges);
    }

    public void findPath(int start, int end, int[] parent, List<Integer> result) {
        if(start == end || end == -1) {
            System.out.println(start);
            result.add(start);
        } else {
            findPath(start, parent[end], parent, result);
            System.out.println(end);
            result.add(end);
        }
    }

    public int findConnectedComponents() {
        int result = 0;
        initializeSearch();

        for (int i = 0; i < graph.getNoOfVertices(); i++) {
            if(!discovered[i]) {
                result++;
                traverse(i);
            }
        }

        return result;
    }

    private void initializeSearch() {
        Arrays.fill(processed, false);
        Arrays.fill(discovered, false);
        Arrays.fill(parent, -1);
    }

    protected void processVertexEarly(int current, List<Integer> vertices) {
        vertices.add(current);
        System.out.println(String.format("Vertex - %d", current));
    }

    protected void processEdge(int current, int neighbour, List<List<Integer>> edges) {
        List<Integer> edge = new ArrayList<>();
        edge.add(current);
        edge.add(neighbour);
        edges.add(edge);
        System.out.println(String.format("Edge - %d %d", current, neighbour));
    }

    protected void processVertexLate(int current, List<Integer> vertices) {
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
