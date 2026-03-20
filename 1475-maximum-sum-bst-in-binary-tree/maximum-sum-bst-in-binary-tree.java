class Solution {
    int r=0;
    int[] f(TreeNode n){
        if(n==null) return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        int[] l=f(n.left),x=f(n.right);
        if(l[0]==1&&x[0]==1&&n.val>l[2]&&n.val<x[1]){
            int s=l[3]+x[3]+n.val;
            r=Math.max(r,s);
            return new int[]{1,Math.min(n.val,l[1]),Math.max(n.val,x[2]),s};
        }
        return new int[]{0,0,0,0};
    }
    public int maxSumBST(TreeNode root){
        f(root);
        return r;
    }
}