class Solution {
    public int missingNumber(int[] nums) {

        int i = 0;
        int n = nums.length;

        while (i < n) {

            int correctPos = nums[i];

            if (correctPos < n && nums[i] != nums[correctPos]) {

                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;

            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {

            if (nums[i] != i) {
                return i;
            }
        }

        return n;
    }
}