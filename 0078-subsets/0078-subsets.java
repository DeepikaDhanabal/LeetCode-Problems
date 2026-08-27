import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, new ArrayList<>(), nums, result);

        return result;
    }

    public void backtrack(int i, List<Integer> current,
                          int[] nums, List<List<Integer>> result) {

        if (i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Don't take nums[i]
        backtrack(i + 1, current, nums, result);

        // Take nums[i]
        current.add(nums[i]);
        backtrack(i + 1, current, nums, result);

        // Undo the choice
        current.remove(current.size() - 1);
    }
}