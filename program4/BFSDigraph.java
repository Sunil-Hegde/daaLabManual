package program4;
import java.util.*;

public class BFSDigraph {
    // Graph class to represent a directed graph using adjacency list
    static class Graph {
        private int vertices; // Number of vertices
        private LinkedList<Integer>[] adjList; // Adjacency list
        // Constructor
        @SuppressWarnings("unchecked")
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        // Function to add an edge to the graph
        void addEdge(int v, int w) {
            adjList[v].add(w); // Add w to v's list
        }
        // Function to perform BFS from a given starting node
        void BFS(int start) {
            // Mark all the vertices as not visited
            boolean[] visited = new boolean[vertices];
            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<>();
            // Mark the current node as visited and enqueue it
            visited[start] = true;
            queue.add(start);
            while (queue.size() != 0) {
                // Dequeue a vertex from the queue and print it
                start = queue.poll();
                System.out.print(start + " ");
                // Get all adjacent vertices of the dequeued vertex
                // If an adjacent vertex has not been visited, mark it as visited and enqueue it
                for (int n : adjList[start]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        Graph graph = new Graph(6);
        // Add edges to the digraph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(4, 5);
        // Print all nodes reachable from node 2
        System.out.println("Following are the nodes reachable from node 2:");
        graph.BFS(2);
        System.out.println();
    }
}
