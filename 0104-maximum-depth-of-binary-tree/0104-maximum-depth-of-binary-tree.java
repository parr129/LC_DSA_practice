class Solution {
    public int maxDepth(TreeNode r) {
        if(r==null)return 0;
        return 1+Math.max(maxDepth(r.left),maxDepth(r.right));
    }
}