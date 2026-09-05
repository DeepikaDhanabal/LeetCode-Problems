class Solution {

    long previous = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= previous) {
            return false;
        }

        previous = root.val;

        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }
}