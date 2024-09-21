# Topological Sort

Obtain the Topological ordering of vertices in a given digraph.

```java
import java.util.*;

public class TopologicalSort {
    private int V; // Number of vertices
    private List<Integer>[] adjList; // Adjacency list
    // Constructor
    @SuppressWarnings("unchecked")
    public TopologicalSort(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList<>();
    }
    // Function to add an edge to the graph
    private void addEdge(int v, int w) {
        adjList[v].add(w);
    }
    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited
        visited[v] = true;
        // Recur for all the vertices adjacent to this vertex
        for (Integer neighbor : adjList[v]) {
            if (!visited[neighbor])
                topologicalSortUtil(neighbor, visited, stack);
        }
        // Push the current vertex to the stack which stores the result
        stack.push(v);
    }
    // The function to do Topological Sort
    private void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        // Print the contents of the stack
        System.out.println("Topological Sort:");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
    // Main method to test the Topological Sort
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        TopologicalSort g = new TopologicalSort(V);
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (scanner.nextInt() == 1) {
                    g.addEdge(i, j);
                }
            }
        }
        // Perform the topological sort
        g.topologicalSort();
        scanner.close();
        System.out.println();
    }
}
```

## Output:

```
sunil@sunil:~daaLabManual/program5$ java TopologicalSort.java
Enter the number of vertices: 5
Enter the adjacency matrix:
0 5 0 0 0
0 0 7 10 0
0 0 0 3 0
0 0 0 0 6
0 2 0 0 0 
Topological Sort:
4 3 2 1 0 
```