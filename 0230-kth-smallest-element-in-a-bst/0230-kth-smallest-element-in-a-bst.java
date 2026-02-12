class Solution {
    int cnt = 0, res = 0;
    public int kthSmallest(TreeNode r, int k) {
        dfs(r, k);
        return res;
    }
    void dfs(TreeNode n, int k) {
        if (n == null) return;
        dfs(n.left, k);
        if (++cnt == k) {
            res = n.val;
            return;
        }
        dfs(n.right, k);
    }
}
