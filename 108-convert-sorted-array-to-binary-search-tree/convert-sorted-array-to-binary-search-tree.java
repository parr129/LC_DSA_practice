class Solution{
    public TreeNode sortedArrayToBST(int[] a){
        return f(a,0,a.length-1);
    }
    TreeNode f(int[] a,int l,int r){
        if(l>r)return null;
        int m=(l+r)/2;
        TreeNode n=new TreeNode(a[m]);
        n.left=f(a,l,m-1);
        n.right=f(a,m+1,r);
        return n;
    }
}