class Solution {
public:
    int integerBreak(int n) {
        if(n <= 3){
            return n - 1;
        }

        int memo[n+1];
        for(int i = 1; i <= 3; i++){
            memo[i] = i;
        }

        for(int i = 4; i <= n; i++){
            int val = i;
            for(int j = 1; j < i; j ++){
                val = max(val, j * memo[i - j]); 
            }
            memo[i] = val;
        } 
        return memo[n];
    }
};