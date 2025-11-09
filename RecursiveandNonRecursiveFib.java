
public class RecursiveandNonRecursiveFib {

    // Recursive method to find Fibonacci number
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Non-recursive (iterative) method to find Fibonacci number
    public static int fibonacciNonRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0,
            curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(
            "Fibonacci number at position " +
                n +
                " (Recursive): " +
                fibonacciRecursive(n)
        );
        System.out.println(
            "Fibonacci number at position " +
                n +
                " (Non-Recursive): " +
                fibonacciNonRecursive(n)
        );
    }
}
#time com - o(2^n) space -o(n)
#time - o(n) space - o(1)









import java.util.*;

public class Fibonacci {

    static int recSteps = 0;
    static int iterSteps = 0;

    // Recursive Fibonacci with step count
    static int fibRecursive(int n) {
        recSteps++;   // count each call
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Iterative Fibonacci with step count
    static int fibIterative(int n) {
        if (n <= 1) {
            iterSteps++;
            return n;
        }

        int a = 0, b = 1, c = 0;
        iterSteps+=2;
        for (int i = 2; i <= n; i++) {
            iterSteps++;     // count each loop iteration
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {

        int n = 5;   // test number

        // Recursive
        recSteps = 0;
        int recAns = fibRecursive(n);

        // Iterative
        iterSteps = 0;
        int iterAns = fibIterative(n);

        System.out.println("Fibonacci Number for n=" + n);
        System.out.println("Recursive Result: " + recAns + " | Steps = " + recSteps);
        System.out.println("Iterative Result: " + iterAns + " | Steps = " + iterSteps);
    }
}

    
