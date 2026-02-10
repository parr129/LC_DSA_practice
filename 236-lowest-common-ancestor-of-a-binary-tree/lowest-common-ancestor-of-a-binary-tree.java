class Solution {
    public TreeNode lowestCommonAncestor(TreeNode r, TreeNode p, TreeNode q) {
        if (r == null || r == p || r == q) return r;
        TreeNode l = lowestCommonAncestor(r.left, p, q);
        TreeNode h = lowestCommonAncestor(r.right, p, q);
        return (l != null && h != null) ? r : (l != null ? l : h);
    }
}
