class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, result, new ArrayList<>(), used);

        return result;
    }

    private void backtrack(
        int[] nums,
        List<List<Integer>> result,
        List<Integer> current,
        boolean[] used
    ) {

        // Base condition
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number
        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            // choose
            current.add(nums[i]);
            used[i] = true;

            // explore
            backtrack(nums, result, current, used);

            // undo
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}