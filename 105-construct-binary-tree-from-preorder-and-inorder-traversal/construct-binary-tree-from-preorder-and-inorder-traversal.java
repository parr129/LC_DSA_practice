class Solution {
    int[] p;
    java.util.Map<Integer,Integer> m = new java.util.HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        p = preorder;
        for (int i = 0; i < inorder.length; i++) m.put(inorder[i], i);
        return f(0, 0, inorder.length);
    }
    TreeNode f(int pi, int ii, int n) {
        if (n <= 0) return null;
        int v = p[pi];
        TreeNode r = new TreeNode(v);
        int k = m.get(v);
        int lsz = k - ii;
        r.left = f(pi + 1, ii, lsz);
        r.right = f(pi + 1 + lsz, k + 1, n - lsz - 1);
        return r;
    }
}
