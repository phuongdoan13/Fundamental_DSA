package A3_Backtracking;

import java.util.*;

public class Backtracking {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // O(n * 2^n)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    private void backtrackSubsetsWithDup(int[] nums, int idx, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));

        for(int i = idx; i < nums.length; i++){
            int curr_num = nums[i];
            list.add(curr_num);
            backtrack(nums, i+1, list);
            list.remove(list.size() - 1);


            while(i < nums.length - 1 && nums[i + 1] == curr_num){
                i++;
            }
        }
    }
}
