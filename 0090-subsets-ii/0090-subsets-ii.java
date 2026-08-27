import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    public void backtrack(int i, int[] nums,
                          List<Integer> current,
                          List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int j = i; j < nums.length; j++) {

            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            current.add(nums[j]);

            backtrack(j + 1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }
}