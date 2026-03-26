class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return f(1,n);
    }
    List<TreeNode> f(int l,int r){
        List<TreeNode> a=new ArrayList<>();
        if(l>r){a.add(null);return a;}
        for(int i=l;i<=r;i++){
            for(TreeNode x:f(l,i-1))
                for(TreeNode y:f(i+1,r)){
                    TreeNode t=new TreeNode(i);
                    t.left=x;t.right=y;
                    a.add(t);
                }
        }
        return a;
    }
}