package ds.graph.dfs;

import ds.graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deep20jain on 12-05-2018.
 */
public class DFS {
    boolean[] discovered;
    boolean[] processed;
    int[] parent;
    int[] entryTime;
    int[] exitTime;
    Graph g;

    int time;
    boolean finished;

    public DFS(Graph g) {
        this.g = g;
        int n = g.getNoOfVertices();
        discovered = new boolean[n];
        processed = new boolean[n];
        parent = new int[n];
        entryTime = new int[n];
        exitTime = new int[n];
    }

    public Traversed traverse(int start) {
        time = 0;
        initTraversal();

        List<Integer> vertices = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();
        Traversed traversed = new Traversed(vertices, edges);

        traverse(start, traversed);
        return traversed;
    }

    private void traverse(int start, Traversed traversed) {
        discovered[start] = true;
        time = time+1;
        entryTime[start] = time;

        if(finished) return;

        processVertexEarly(start, traversed.vertices);

        Graph.EdgeNode edge = g.getEdges()[start];

        while (edge!=null) {
            int neighbour = edge.getY();

            if(!discovered[neighbour]) {
                parent[neighbour] = start;
                processEdge(start, neighbour, traversed.edges);
                traverse(neighbour, traversed);
            } else if(!processed[neighbour] || g.isDirected()) {
                processEdge(start, neighbour, traversed.edges);
            }

            if(finished) return;

            edge = edge.getNext();
        }

        processVertexLate(start, traversed.vertices);

        time = time+1;
        exitTime[start]=time;
        processed[start] = true;
    }

    private void initTraversal() {
        Arrays.fill(parent, -1);
        Arrays.fill(entryTime, -1);
        Arrays.fill(exitTime, -1);
        Arrays.fill(discovered, false);
        Arrays.fill(processed, false);
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

    public class Traversed {
        List<Integer> vertices;
        List<List<Integer>> edges;

        public Traversed(List<Integer> vertices, List<List<Integer>> edges) {
            this.vertices = vertices;
            this.edges = edges;
        }
    }
}
