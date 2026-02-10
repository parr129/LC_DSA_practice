class Solution {
    int d = 0;
    public int diameterOfBinaryTree(TreeNode r) {
        dfs(r);
        return d;
    }
    int dfs(TreeNode n) {
        if (n == null) return 0;
        int l = dfs(n.left);
        int r = dfs(n.right);
        d = Math.max(d, l + r);
        return 1 + Math.max(l, r);
    }
}
