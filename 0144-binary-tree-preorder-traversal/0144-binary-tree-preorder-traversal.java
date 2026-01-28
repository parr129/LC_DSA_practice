class Solution{
 public List<Integer> preorderTraversal(TreeNode r){
  List<Integer> o=new ArrayList<>();
  dfs(r,o);
  return o;
 }
 void dfs(TreeNode r,List<Integer> o){
  if(r==null) return;
  o.add(r.val);
  dfs(r.left,o);
  dfs(r.right,o);
 }
}
