import java.util.Scanner;

public class KnapsackDP {

    public static int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        // Bottom-up DP
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        val[i - 1] + dp[i - 1][w - wt[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W]; // Maximum value
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        System.out.print("Enter capacity of knapsack: ");
        int W = sc.nextInt();

        int val[] = new int[n];
        int wt[] = new int[n];

        System.out.println("Enter values of items: ");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.println("Enter weights of items: ");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int maxVal = knapSack(W, wt, val, n);
        System.out.println("Maximum value in Knapsack = " + maxVal);

        sc.close();
    }
}

