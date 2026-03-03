class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode r){
        TreeMap<Integer,List<int[]>> m=new TreeMap<>();
        dfs(r,0,0,m);
        List<List<Integer>> o=new ArrayList<>();
        for(List<int[]> l:m.values()){
            Collections.sort(l,(a,b)->a[1]==b[1]?a[2]-b[2]:a[1]-b[1]);
            List<Integer> t=new ArrayList<>();
            for(int[] x:l) t.add(x[2]);
            o.add(t);
        }
        return o;
    }
    void dfs(TreeNode n,int x,int y,TreeMap<Integer,List<int[]>> m){
        if(n==null) return;
        m.putIfAbsent(x,new ArrayList<>());
        m.get(x).add(new int[]{x,y,n.val});
        dfs(n.left,x-1,y+1,m);
        dfs(n.right,x+1,y+1,m);
    }
}