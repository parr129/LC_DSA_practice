class Solution {
    int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
    public int minDays(int[][] g) {
        if(f(g)!=1) return 0;
        int m=g.length,n=g[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1){
                    g[i][j]=0;
                    if(f(g)!=1) return 1;
                    g[i][j]=1;
                }
            }
        }
        return 2;
    }
    int f(int[][] g){
        int m=g.length,n=g[0].length,c=0;
        boolean[][] v=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1&&!v[i][j]){
                    c++;
                    dfs(g,v,i,j);
                }
            }
        }
        return c;
    }
    void dfs(int[][] g,boolean[][] v,int i,int j){
        int m=g.length,n=g[0].length;
        v[i][j]=true;
        for(int[] x:d){
            int ni=i+x[0],nj=j+x[1];
            if(ni>=0&&nj>=0&&ni<m&&nj<n&&g[ni][nj]==1&&!v[ni][nj]){
                dfs(g,v,ni,nj);
            }
        }
    }
}