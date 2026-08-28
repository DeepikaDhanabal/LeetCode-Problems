class Solution {

    int sum = 0;

    public int subsetXORSum(int[] nums) {

        backtrack(nums, 0, 0);

        return sum;
    }

    private void backtrack(int[] nums, int index, int xor) {

        if (index == nums.length) {
            sum += xor;
            return;
        }

        // Don't take nums[index]
        backtrack(nums, index + 1, xor);

        // Take nums[index]
        backtrack(nums, index + 1, xor ^ nums[index]);
    }
}