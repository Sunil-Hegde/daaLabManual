package program11;
import java.util.Scanner;

public class Kruskal {

    int parent[] = new int[10];  // Array to store the parent of each node
    // Method to find the root of the set containing element m
    int find(int m) {
        while (parent[m] != 0)
            m = parent[m];
        return m;
    }
    // Method to perform the union of two sets
    void union(int i, int j) {
        parent[j] = i;  // Make the root of set j point to the root of set i
    }
    // Kruskal's algorithm to find the Minimum Spanning Tree
    void kruskal(int a[][], int n) {
        int u = 0, v = 0, min, sum = 0, k = 0;
        // Repeat until n-1 edges are found
        while (k < n - 1) {
            min = 99;  // Set to a large number to find the minimum edge
            // Find the minimum edge in the graph, ignoring 0-weight (no connection) edges
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a[i][j] != 0 && a[i][j] < min && i != j) {  // Ignore zero weights
                        min = a[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            // Find the roots of the sets that u and v belong to
            int i = find(u);
            int j = find(v);
            // If u and v belong to different sets, add the edge to the MST
            if (i != j) {
                union(i, j);  // Merge the sets
                System.out.println("(" + u + "," + v + ") = " + a[u][v]);
                sum += a[u][v];  // Add the weight of the edge to the total cost
                k++;  // Increase the edge count in the MST
            }
            // Remove the selected edge from consideration by setting its weight to a large value
            a[u][v] = a[v][u] = 99;
        }
        // Output the total cost of the Minimum Spanning Tree
        System.out.println("The cost of the minimum spanning tree = " + sum);
    }

    public static void main(String[] args) {
        int a[][] = new int[10][10];
        Scanner sc = new Scanner(System.in);
        // Input number of vertices
        System.out.println("Enter the number of vertices of the graph:");
        int n = sc.nextInt();
        // Input the weighted adjacency matrix
        System.out.println("Enter the weighted adjacency matrix (use 0 for no connection):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // Create an object of Kruskal class and run the algorithm
        Kruskal k = new Kruskal();
        k.kruskal(a, n);
        sc.close();
    }
}


