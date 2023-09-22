class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(), coins.end());
        vector<int> memo(amount + 1, amount + 1);
        memo[0] = 0;
        for(int amt = 1; amt <= amount; amt++){
            for(int& coin : coins){
                if(amt - coin >= 0){
                    memo[amt] = min(memo[amt], memo[amt - coin] + 1);
                }else{
                    break;
                }
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }
};