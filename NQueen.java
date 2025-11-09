
public class NQueen {
    static int N; // size of the board

    // Function to print the chessboard configuration
    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if a queen can be placed at board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check this column on the upper side
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper right diagonal
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive function to solve N Queen problem
    static boolean solveNQUtil(int[][] board, int row) {
        // Base case: all queens placed
        if (row >= N)
            return true;

        // Try placing a queen in all columns of the current row
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // place queen

                // Recur to place the rest of the queens
                if (solveNQUtil(board, row + 1))
                    return true;

                // Backtrack: remove the queen
                board[row][col] = 0;
            }
        }
        return false; // no valid place in this row
    }

    // Main function to solve the N Queen problem
    static boolean solveNQ(int n) {
        N = n;
        int[][] board = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.println("No solution exists for N = " + N);
            return false;
        }

        printSolution(board);
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        int n = 8; // You can change this value to test different N
        solveNQ(n);
    }
}




public class nQueen {
    static final int N = 8;

    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            System.out.println();
        }
    }

    static boolean isSafe(int board[][], int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean solveNQUtil(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        board[0][0] = 1;

        if (!solveNQUtil(board, 1))
            System.out.println("Solution does not exist");
        else
            printSolution(board);
    }
}

Time Complexity: O(N!)
Space Complexity: O(N)


place q1 at 1,1
place q2 at 2,3
place q3 at 3,5
after checking all col safe 
place q4 at 4,2
no safe place found so backtrack remove q4 and try new col for row 4
move to q4 at 4,7
place at q5 5,2
place at q6 6,4
place at q7 7,6
no safe place found so backtrack again remove last few q
final q8 at 8,4
