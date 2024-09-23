package program15;
import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSumDP {
    // Function to check if a subset with the given sum exists and to retrieve the subset
    public static boolean subsetSum(int[] arr, int sum, ArrayList<Integer> subset) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // Initialize dp array: dp[i][0] is true for all i
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        // Fill dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // If the subset sum doesn't exist, return false
        if (!dp[n][sum]) {
            return false;
        }
        // Trace back the elements contributing to the subset sum
        int i = n, j = sum;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                subset.add(arr[i - 1]);
                j -= arr[i - 1];
            }
            i--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        // Input the array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // Input the target sum
        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();
        // Initialize subset array and time the execution
        ArrayList<Integer> subset = new ArrayList<>();
        long startTime = System.nanoTime();
        boolean hasSubsetSum = subsetSum(arr, sum, subset);
        long endTime = System.nanoTime();
        // Output the result
        System.out.println("Subset sum exists: " + hasSubsetSum);
        if (hasSubsetSum) {
            System.out.println("Subset contributing to the sum: " + subset);
        }
        // Display the time complexity in milliseconds
        double timeElapsed = (endTime - startTime) / 1e6;
        System.out.println("Time Taken: " + timeElapsed + " ms");
        // Close the scanner
        scanner.close();
    }
}
