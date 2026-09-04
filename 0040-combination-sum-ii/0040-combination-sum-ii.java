class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to group duplicates and allow early pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Stop early if candidate exceeds target (since array is sorted)
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate elements at the same depth level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);
            // Pass 'i + 1' to ensure each element is used only once
            backtrack(candidates, remain - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}