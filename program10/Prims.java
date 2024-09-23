package program10;
import java.util.Scanner;

public class Prims {

    public static void main(String[] args) {
        int w[][] = new int[10][10];  // Weight matrix for the graph
        int n, i, j, s, k = 0, min, sum = 0, u = 0, v = 0, flag = 0;
        int sol[] = new int[10];  // Array to keep track of selected vertices
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.println("Enter the number of vertices:");
        n = sc.nextInt();

        // Initialize solution array
        for (i = 1; i <= n; i++)
            sol[i] = 0;

        // Input the weighted graph
        System.out.println("Enter the weighted adjacency matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        // Input the source vertex
        System.out.println("Enter the source vertex:");
        s = sc.nextInt();
        sol[s] = 1;  // Mark the source vertex as selected
        k = 1;

        // Prim's Algorithm: Loop until all vertices are included
        while (k <= n - 1) {
            min = 99;  // Set min to a large value to find the smallest weight

            // Find the minimum edge (u, v) where u is already in the MST and v is not
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (sol[i] == 1 && sol[j] == 0) {  // i is in MST, j is not
                        if (i != j && min > w[i][j]) {  // Ensure not self-loop and check for minimum weight
                            min = w[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }

            // Add vertex v to the MST
            sol[v] = 1;
            sum += min;  // Add the weight of the edge to the total sum
            k++;

            // Output the selected edge and its weight
            System.out.println(u + " -> " + v + " = " + min);
        }

        // Check if all vertices are included in the MST
        for (i = 1; i <= n; i++) {
            if (sol[i] == 0) {
                flag = 1;  // Not all vertices are included
                break;
            }
        }

        // Output the result
        if (flag == 1)
            System.out.println("No spanning tree exists.");
        else
            System.out.println("The cost of the minimum spanning tree is: " + sum);

        sc.close();
    }
}
