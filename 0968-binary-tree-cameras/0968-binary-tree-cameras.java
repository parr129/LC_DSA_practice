class Solution {
    int c=0;
    public int minCameraCover(TreeNode r){
        return dfs(r)==0?c+1:c;
    }
    int dfs(TreeNode n){
        if(n==null) return 2;
        int l=dfs(n.left), r=dfs(n.right);
        if(l==0||r==0){c++;return 1;}
        if(l==1||r==1) return 2;
        return 0;
    }
}