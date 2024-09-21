# Warshalls's Algorithm

Compute the transitive closure of a given directed graph using Warshall’s Algorithm.

```java
import java.util.Scanner;

public class WarshallsAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get the number of vertices
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        // Initialize the adjacency matrix
        int[][] graph = new int[vertices][vertices];
        // Get the adjacency matrix from the user
        System.out.println("Enter the adjacency matrix (0 for no edge, 1 for edge):");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        // Find the transitive closure using Warshall's Algorithm
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    graph[i][j] = graph[i][j] | (graph[i][k] & graph[k][j]);
                }
            }
        }
        // Display the transitive closure matrix
        System.out.println("Transitive Closure:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
```

## Output:

```
sunil@sunil:~daaLabManual/program6$ java WarshallsAlgorithm.java
Enter the number of vertices: 5
Enter the adjacency matrix (0 for no edge, 1 for edge):
0 1 0 0 0
0 0 1 1 0
0 0 0 1 0
0 0 0 0 1
0 1 0 0 0
Transitive Closure:
0 1 1 1 1 
0 1 1 1 1 
0 1 1 1 1 
0 1 1 1 1 
0 1 1 1 1 
```