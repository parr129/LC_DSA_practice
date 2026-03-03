class Solution {
    int[] a,s,ans;
    List<List<Integer>> g;
    public int[] sumOfDistancesInTree(int n, int[][] e) {
        g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int[] x:e){
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }
        a=new int[n];
        s=new int[n];
        ans=new int[n];
        dfs1(0,-1);
        ans[0]=a[0];
        dfs2(0,-1);
        return ans;
    }
    void dfs1(int v,int p){
        s[v]=1;
        for(int u:g.get(v)){
            if(u==p) continue;
            dfs1(u,v);
            s[v]+=s[u];
            a[v]+=a[u]+s[u];
        }
    }
    void dfs2(int v,int p){
        for(int u:g.get(v)){
            if(u==p) continue;
            ans[u]=ans[v]-s[u]+(a.length-s[u]);
            dfs2(u,v);
        }
    }
}