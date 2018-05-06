package ds.graph;

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
        BFS bfs = new BFS(noOfVertices);
        return bfs.traverse(this, 0);
    }
}
