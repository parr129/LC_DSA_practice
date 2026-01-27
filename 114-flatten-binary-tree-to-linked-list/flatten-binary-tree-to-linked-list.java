class Solution {
    TreeNode p=null;
    public void flatten(TreeNode r) {
        if(r==null)return;
        flatten(r.right);
        flatten(r.left);
        r.right=p;
        r.left=null;
        p=r;
    }
}
