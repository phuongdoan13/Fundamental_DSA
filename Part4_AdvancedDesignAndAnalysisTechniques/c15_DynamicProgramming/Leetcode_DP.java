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

    public int climbStairs(int n) {
        /* 
            Q70. Climbing stairs
            You are climbing a staircase. 
            It takes n steps to reach the top.
            Each time you can either climb 1 or 2 steps. 
            In how many distinct ways can you climb to the top?
        */
        // O(n) O(1)
        if(n<2) return 1;
        int prev = 1;
        int prev_prev = 1;
        int curr = 1;
        for(int i = 2; i <= n; i++){
            curr = prev + prev_prev;
            prev_prev = prev;
            prev = curr;
        }
        return curr;
    }

    public int minCostClimbingStairs(int[] cost) {
        /* 
            Q746. Min Cost Climbing Stairs
            You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
            Once you pay the cost, you can either climb one or two steps.
            You can either start from the step with index 0, or the step with index 1.
            Return the minimum cost to reach the top of the floor.
        */
        // O(n) O(n)
        if(cost.length <= 2) return Math.min(cost[0], cost[1]);
        int[] memo = new int[cost.length + 1];
        for(int i = 2; i < memo.length; i++){
            int takeOneStep = memo[i-1] + cost[i-1];
            int takeTwoSteps = memo[i-2] + cost[i-2];
            memo[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        return memo[memo.length - 1];
    }

    public int houseRobber(int[] nums) {
        /* 
            Q198. House Robber
            You are a professional robber planning to rob houses along a street. 
            Each house has a certain amount of money stashed, 
            the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected 
            and it will automatically contact the police if two adjacent houses were broken into on the same night.

            Given an integer array nums representing the amount of money of each house, 
            return the maximum amount of money you can rob tonight without alerting the police.
            
            Example 1
            Input: nums = [1,2,3,1]
            Output: 4
            
        */
        // O(n) O(1)
        int robPrevHouse = nums[0];
        int notRobPrevHouse = 0;
        
        for(int i = 1; i < nums.length; i++){
            int rob =  nums[i] + notRobPrevHouse;
            int notRob = Math.max(robPrevHouse,notRobPrevHouse);
            robPrevHouse = rob;
            notRobPrevHouse = notRob;
        }
        return Math.max(robPrevHouse,notRobPrevHouse);
    }
    public static void main(String[] args) {
        Leetcode_DP obj = new Leetcode_DP();
        System.out.println(obj.houseRobber(new int[]{2,7,9,3,1}));
    }
}
