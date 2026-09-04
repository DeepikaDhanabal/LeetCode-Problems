class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip invalid paths where candidate exceeds remaining target
            if (remain - candidates[i] < 0) {
                continue;
            }

            current.add(candidates[i]);
            // Pass 'i' (not 'i + 1') because the same element can be reused
            backtrack(candidates, remain - candidates[i], i, current, result);
            current.remove(current.size() - 1); // Undo decision
        }
    }
}