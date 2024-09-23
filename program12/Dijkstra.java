package program12;

import java.util.Scanner;

public class Dijkstra {
    int d[] = new int[10];  // Distance array
    int p[] = new int[10];  // Predecessor array
    int visited[] = new int[10];  // Visited array to track processed vertices
    // Method to perform Dijkstra's Algorithm
    public void dijk(int[][] a, int s, int n) {
        int u = -1, v, i, j, min;
        // Initialize distance and predecessor arrays
        for (i = 0; i < n; i++) {
            d[i] = 99;  // Initialize distances to a large number
            visited[i] = 0;  // Mark all vertices as unvisited
            p[i] = -1;  // No predecessor for any vertex initially
        }
        d[s] = 0;  // Distance of source vertex to itself is 0
        // Main loop of Dijkstra's algorithm
        for (i = 0; i < n; i++) {
            min = 99;
            u = -1;
            // Find the unvisited vertex with the smallest distance
            for (j = 0; j < n; j++) {
                if (visited[j] == 0 && d[j] < min) {
                    min = d[j];
                    u = j;
                }
            }
            // Mark the vertex as visited
            visited[u] = 1;
            // Update the distances of the adjacent vertices
            for (v = 0; v < n; v++) {
                if (a[u][v] != 0 && visited[v] == 0 && d[u] + a[u][v] < d[v]) {
                    d[v] = d[u] + a[u][v];  // Update the distance
                    p[v] = u;  // Set the predecessor
                }
            }
        }
    }
    // Method to print the shortest path from source to a vertex
    void path(int v, int s) {
        if (p[v] != -1) {
            path(p[v], s);  // Recursively find the path
        }
        if (v != s) {
            System.out.print("->" + v);  // Print the vertex in the path
        }
    }
    // Method to display the shortest paths and their distances
    void display(int s, int n) {
        for (int i = 0; i < n; i++) {
            if (i != s) {
                System.out.print(s);  // Print source vertex
                path(i, s);  // Print the path to vertex i
                System.out.print(" = " + d[i] + "\n");  // Print the distance to vertex i
            }
        }
    }
    public static void main(String[] args) {
        int a[][] = new int[10][10];  // Adjacency matrix
        int i, j, n, s;
        Scanner sc = new Scanner(System.in);
        // Input the number of vertices
        System.out.println("Enter the number of vertices:");
        n = sc.nextInt();
        // Input the weighted adjacency matrix
        System.out.println("Enter the weighted matrix (use 0 for no connection):");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // Input the source vertex
        System.out.println("Enter the source vertex:");
        s = sc.nextInt();
        // Create a Dijkstra object and run the algorithm
        Dijkstra tr = new Dijkstra();
        tr.dijk(a, s, n);
        // Display the shortest paths
        System.out.println("The shortest paths from source vertex " + s + " to the remaining vertices are:");
        tr.display(s, n);
        sc.close();
    }
}
