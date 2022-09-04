package Part4_AdvancedDesignAndAnalysisTechniques.c15_DynamicProgramming;

public class Leetcode_DP {
    public int tribonacci(int n) {
        /*
            Q1137: The Tribonacci sequence Tn is defined as follows:
            T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
            Given n, return the value of Tn.
        */
        if(n < 2)
            return n;
        if(n == 2)
            return 1;
        int previous_previous_previous = 0;
        int previous_previous = 1;
        int previous = 1;
        int new_sum = 0;
        for(int i = 3; i <= n; i++){
            new_sum = previous + previous_previous + previous_previous_previous;
            previous_previous_previous = previous_previous;
            previous_previous = previous;
            previous = new_sum;
        }
        return new_sum;
    }
    public int fibonacci(int n) {
        /*
            Q509. Fibonacci Number
            The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
            F(0) = 0, F(1) = 1
            F(n) = F(n - 1) + F(n - 2), for n > 1.
            Given n, calculate F(n).
         */
        // O(n) O(n)
        if(n < 2) return n;
        int[] memo = new int[n+ 1];
        memo[1] = 1;

        for(int i = 2; i <= n; i++) memo[i] = memo[i-1] + memo[i-2];

        return memo[n];

    }
    public static void main(String[] args) {
        Leetcode_DP inst = new Leetcode_DP();
        System.out.println(inst.tribonacci(3));
        System.out.println(inst.fibonacci(3));
    }
}
