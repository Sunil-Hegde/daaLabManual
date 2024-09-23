package program14;
public class NQueenProblem {
    final int N = 5;
    // Function to print the solution
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q |");
                else
                    System.out.print(". |");
            }
            System.out.println();
        }
    }
    // Function to check if a queen can be placed on board[row][col]
    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        // Check this row on the left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        // Check lower diagonal on the left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
    // Recursive utility function to solve N Queen problem
    boolean solveNQUtil(int board[][], int col) {
        // If all queens are placed, return true
        if (col >= N)
            return true;
        // Try placing queen in all rows one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place this queen in board[i][col]
                // Recur to place rest of the queens
                if (solveNQUtil(board, col + 1))
                    return true;
                board[i][col] = 0; // BACKTRACK
            }
        }
        // If queen cannot be placed in any row, return false
        return false;
    }
    // This function solves the N Queen problem
    boolean solveNQ() {
        int board[][] = new int[N][N];  // Initialize an empty board
        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }
        printSolution(board);  // Print the solution if it exists
        return true;
    }
    public static void main(String[] args) {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();  // Call the function to solve the N-Queen problem
    }
}
