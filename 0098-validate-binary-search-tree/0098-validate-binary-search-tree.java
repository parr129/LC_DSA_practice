class Solution {
    long p = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode r) {
        if (r == null) return true;
        if (!isValidBST(r.left)) return false;
        if (r.val <= p) return false;
        p = r.val;
        return isValidBST(r.right);
    }
}
