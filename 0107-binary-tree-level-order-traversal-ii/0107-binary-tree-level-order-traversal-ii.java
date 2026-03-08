class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode r) {
        LinkedList<List<Integer>> a=new LinkedList<>();
        if(r==null)return a;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(r);
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> t=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode n=q.poll();
                t.add(n.val);
                if(n.left!=null)q.add(n.left);
                if(n.right!=null)q.add(n.right);
            }
            a.addFirst(t);
        }
        return a;
    }
}