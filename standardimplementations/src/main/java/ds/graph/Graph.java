package ds.graph;

import ds.graph.bfs.BFS;
import ds.graph.dfs.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * As per "The Algorithm Design Manual" by Skiena
 * Created by deep20jain on 06-05-2018.
 */
public class Graph {
    int noOfVertices;
    int noOfEdges;
    boolean directed;
    int degree[];
    EdgeNode edges[];

    public class EdgeNode {
        int y;
        int weight;
        EdgeNode next;

        EdgeNode(int y, int weight, EdgeNode next) {
            this.y = y;
            this.weight = weight;
            this.next = next;
        }

        public int getY() {
            return y;
        }

        public int getWeight() {
            return weight;
        }

        public EdgeNode getNext() {
            return next;
        }
    }

    public Graph(int maxVertices, boolean directed) {
        this.directed = directed;
        noOfVertices = maxVertices;
        degree = new int[maxVertices];
        edges = new EdgeNode[maxVertices];
    }

    public void insertEdge(int x, int y, boolean directed) {
        EdgeNode edge = new EdgeNode(y, 0, edges[x]);
        edges[x] = edge;
        degree[x]++;

        if (!directed) {
            insertEdge(y, x, true);
        } else {
            noOfEdges++;
        }
    }

    public List<List<Integer>> print() {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < noOfVertices; i++) {
            List<Integer> list = new ArrayList<>();
            System.out.print(i);
            list.add(i);

            EdgeNode node = edges[i];
            while (node != null) {
                System.out.print(" " + node.y);
                list.add(node.y);
                node = node.next;
            }

            System.out.println();
            res.add(list);
        }

        return res;
    }

    public BFS.Traversed bfs() {
        BFS bfs = new BFS(this, noOfVertices);
        return bfs.traverse(0);
    }

    public DFS.Traversed dfs() {
        DFS dfs = new DFS(this);
        return dfs.traverse(0);
    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public int getNoOfEdges() {
        return noOfEdges;
    }

    public boolean isDirected() {
        return directed;
    }

    public int[] getDegree() {
        return degree;
    }

    public EdgeNode[] getEdges() {
        return edges;
    }
}
