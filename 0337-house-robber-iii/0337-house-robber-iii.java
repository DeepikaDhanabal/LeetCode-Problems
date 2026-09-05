class Solution {
    public int rob(TreeNode root) {
        int[] result = solve(root);
        return Math.max(result[0], result[1]);
    }

    public int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // Rob current house
        int rob = root.val + left[1] + right[1];

        // Don't rob current house
        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}