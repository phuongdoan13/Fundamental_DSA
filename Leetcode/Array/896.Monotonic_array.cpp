class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        if(nums.size() <= 2) return true;
        int cmp = 0;
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] > nums[i - 1] && cmp == -1) return false;
            if(nums[i] < nums[i - 1] && cmp == 1) return false;
            cmp = nums[i] > nums[i - 1] ? 1 : (nums[i] < nums[i - 1] ? -1 : 0);
        }
        return true;
    }
};