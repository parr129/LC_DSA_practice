class Solution {
    int i=0;
    public TreeNode recoverFromPreorder(String s){
        return f(s,0);
    }
    TreeNode f(String s,int d){
        int j=i,c=0;
        while(j<s.length()&&s.charAt(j)=='-'){j++;c++;}
        if(c!=d) return null;
        i=j;
        int v=0;
        while(i<s.length()&&Character.isDigit(s.charAt(i))){
            v=v*10+(s.charAt(i++)-'0');
        }
        TreeNode n=new TreeNode(v);
        n.left=f(s,d+1);
        n.right=f(s,d+1);
        return n;
    }
}