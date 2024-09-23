package program13;

public class TSP {
    static int n = 4;  // Number of cities
    static int MAX = 1000000;  // A large value representing infinity
    // Distance matrix
    static int[][] dist = {
        {0, 0, 0, 0, 0},
        {0, 0, 10, 30, 20},
        {0, 10, 0, 60, 0},
        {0, 30, 60, 0, 50},
        {0, 20, 0, 50, 0}
    };
    // Memoization table to store subproblem results
    static int[][] memo = new int[n + 1][1 << (n + 1)];
    // Recursive function to calculate the minimum cost
    static int fun(int i, int mask) {
        if (mask == ((1 << i) | 3)) {  // Base case: only start and current city are left
            return dist[1][i];  // Return distance from start to current city
        }
        if (memo[i][mask] != 0) {  // If this subproblem has already been solved
            return memo[i][mask];  // Return the stored result
        }
        int res = MAX;  // Initialize result to a large value
        // Try visiting every other city and find the minimum cost
        for (int j = 1; j <= n; j++) {
            if ((mask & (1 << j)) != 0 && j != i && j != 1) {  // Check if city j is in the mask and is different from i
                res = Math.min(res, fun(j, mask & (~(1 << i))) + dist[j][i]);
            }
        }
        return memo[i][mask] = res;  // Store the result and return it
    }
    public static void main(String[] args) {
        int ans = MAX;  // Initialize the answer to a large value
        // Try every possible starting city and find the minimum cost
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, fun(i, (1 << (n + 1)) - 1) + dist[i][1]);
        }
        // Output the result
        System.out.println("The cost of the most efficient tour = " + ans);
    }
}
