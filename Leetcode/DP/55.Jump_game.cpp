class Solution {
public:
    bool canJump(vector<int>& nums) {
        vector<bool> memo(nums.size());
        memo[nums.size() - 1] = true;
        int last_reachable_index = nums.size() - 1;
        for(int i = nums.size() - 2; i >= 0; i--){
            if(nums[i] + i < last_reachable_index){
                memo[i] = false;
            }else{
                memo[i] = true;
                last_reachable_index = i;
            }
        }
        return memo[0];
    }
};