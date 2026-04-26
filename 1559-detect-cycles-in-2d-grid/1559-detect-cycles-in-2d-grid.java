class Solution {
    int m,n;
    char[][] g;
    boolean[][] v;
    int[] d={0,1,0,-1,0};
    
    public boolean containsCycle(char[][] grid) {
        g=grid;
        m=g.length;
        n=g[0].length;
        v=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!v[i][j]){
                    if(f(i,j,-1,-1,g[i][j])) return true;
                }
            }
        }
        return false;
    }
    
    boolean f(int i,int j,int pi,int pj,char c){
        if(v[i][j]) return true;
        v[i][j]=true;
        
        for(int k=0;k<4;k++){
            int x=i+d[k],y=j+d[k+1];
            if(x<0||y<0||x>=m||y>=n) continue;
            if(g[x][y]!=c||(x==pi&&y==pj)) continue;
            if(f(x,y,i,j,c)) return true;
        }
        return false;
    }
}