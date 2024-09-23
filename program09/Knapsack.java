package program09;
class Knapsack {
    static int max(int a, int b) { 
        return (a > b) ? a : b;
    }
    static int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0)
            return 0;
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
        else
            return max(
                val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),  
                knapSack(W, wt, val, n - 1)                            
            );
    }
    public static void main(String args[]) {
        int profit[] = {60, 100, 120};  // Profit values of the items
        int weight[] = {10, 20, 30};    // Weight values of the items
        int W = 50;                     // Maximum capacity of the knapsack
        int n = profit.length;          // Number of items
        // Print the result of the knapsack problem
        System.out.println("Maximum profit: " + knapSack(W, weight, profit, n));
    }
}
