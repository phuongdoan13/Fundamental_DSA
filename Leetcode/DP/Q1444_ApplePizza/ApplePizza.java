package Leetcode.DP.Q1444_ApplePizza;

public class ApplePizza {

  public int ways(String[] pizza, int k) {
      int ans = 0;
      int MOD = 1_000_000_007;
      int R = pizza.length;
      int C = pizza[0].length();
      int[][] apples = new int[R + 1][C + 1];
      int[][][] dp = new int[k][R + 1][C + 1];
      
      
      for(int r = R - 1; r >= 0; r--){
          for(int c = C - 1; c >= 0; c--){
              apples[r][c] = (pizza[r].charAt(c) == 'A' ? 1 : 0)  + apples[r + 1][c] + apples[r][c + 1] - apples[r+1][c+1];
              dp[0][r][c] = apples[r][c] > 0 ? 1 : 0;
          }
      }

      for(int remain = 1; remain < k; remain++){
          for(int r = 0; r < R; r++){
              for(int c = 0; c < C; c++){
                  for(int next_row = r + 1; next_row < R; next_row++){
                      if(apples[r][c] - apples[next_row][c] > 0){
                          dp[remain][r][c] += dp[remain - 1][next_row][c];
                          dp[remain][r][c] %= MOD;
                      }
                  }
                  for(int next_col = c + 1; next_col < C; next_col++){
                      if(apples[r][c] - apples[r][next_col] > 0){
                          dp[remain][r][c] += dp[remain - 1][r][next_col];
                          dp[remain][r][c] %= MOD;
                      }
                  }
              }
          }
      }
      return dp[k-1][0][0];
  }
}
