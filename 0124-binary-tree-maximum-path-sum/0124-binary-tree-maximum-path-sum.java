/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int r=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode n){
        go(n);
        return r;
    }
    int go(TreeNode n){
        if(n==null)return 0;
        int l=Math.max(0,go(n.left));
        int m=Math.max(0,go(n.right));
        r=Math.max(r,n.val+l+m);
        return n.val+Math.max(l,m);
    }
}
