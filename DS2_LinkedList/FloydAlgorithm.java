package DS2_LinkedList;

class FloydAlgorithm{
    public FloydAlgorithm(){

    }

    public int findDuplicate(int[] nums) {
        // Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
        // There is only one repeated number in nums, return this repeated number.
        // You must solve the problem without modifying the array nums and uses only constant extra space.
        int hare = nums[0];
        int tortoise = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];

        while(tortoise != hare){
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }
}
