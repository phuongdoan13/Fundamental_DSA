package A2_BitManipulation;

import java.math.BigInteger;

public class BitManipulation {
    // BASIC
    static boolean getBit(int num, int i){
        // Get the i_th bit (indexed-0 from the right);
        return ((num & (1 << i)) != 0);
    }

    static int setBit(int num, int i){
        // Turn the i_th bit into 1 (indexed-0 from the right); 
        // E.g. setBit(10, 1): 1000 | 0001 -> 1001
        return num | (1 << i);
    }

    static int clearBit(int num, int i){
        // Turn the i_th bit into 0;
        // E.g. clearBit(15, 2): 1111 & 1011 -> 1011
        return num & ~(1 << i);
    }

    static int clearBitsMSBThroughI(int num, int i){
        // clear from MSB to i_bit(inclusive)
        // E.g. clearBitsMSBThroughI(15, 3): 1111 & 0111 = 0111
        int mask = (1 << i) - 1; // 1111 - 1 = 0111;
        return num & mask; 
    }

    static int clearBitsIThrough0(int num, int i){
        // clear from i_th to MSB (inclusive)
        // E.g clearBitsIThrough0(15, 2): 1111 & 1000 = 1000
        int mask = (-1 << (i + 1));// 1111 shift left by 3
        return num & mask;
    }

    static String addBinary(String a, String b){
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger ans; BigInteger carry;
        while(y.compareTo(zero) != 0){
            ans = x.xor (y);
            carry = x.and(y).shiftLeft(1);
            x = ans;
            y = carry;
        }
        return x.toString(2);

    }

    static int[] countBitsFrom1ToN(int n){
        // Count the number of bits for each integer from 1 to n
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            if(i % 2 == 0) dp[i] = dp[i/2];
            else dp[i] = dp[i-1] + 1;
        }
        return dp;
    }

    static int singleNumber(int[] nums) {
        // Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans ^= nums[i];
        }
        return ans;
    }
    
    public static void main(String[] args) {
        // System.out.println(getBit(9, 1));
        // System.out.println(setBit(8, 0));
        // System.out.println(clearBit(15, 2));
        // System.out.println(clearBitsMSBThroughI(15, 3));
        // System.out.println(clearBitsIThrough0(15, 2)); 
        System.out.println(addBinary("1", "0"));
    }
}
