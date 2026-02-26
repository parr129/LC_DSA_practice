class Solution{
    public boolean isBalanced(TreeNode r){
        return h(r)>=0;
    }
    int h(TreeNode n){
        if(n==null)return 0;
        int l=h(n.left),r=h(n.right);
        if(l<0||r<0||Math.abs(l-r)>1)return -1;
        return Math.max(l,r)+1;
    }
}