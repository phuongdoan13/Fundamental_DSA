class Solution {
public:
    int rob(vector<int>& nums) {
        int robPrevPrevHouse = 0;
        int robPrevHouse = nums[0];
        for(int i = 1; i < nums.size(); i++){
            int curr = max(robPrevPrevHouse + nums[i], robPrevHouse);
            robPrevPrevHouse = robPrevHouse;
            robPrevHouse = curr;
        }
        return max(robPrevPrevHouse, robPrevHouse);
    }
};