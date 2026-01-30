class Solution {
    public boolean isBipartite(int[][] g){
        int n=g.length;
        int[] c=new int[n];
        for(int i=0;i<n;i++) if(c[i]==0 && !dfs(g,i,1,c)) return false;
        return true;
    }
    boolean dfs(int[][] g,int u,int cl,int[] c){
        c[u]=cl;
        for(int v:g[u]){
            if(c[v]==0){
                if(!dfs(g,v,-cl,c)) return false;
            }else if(c[v]==cl) return false;
        }
        return true;
    }
}
