class Solution {
    int[][] g;
    int n,m;
    int f(int i,int j){
        if(i<0||j<0||i>=n||j>=m||g[i][j]==0) return 0;
        g[i][j]=0;
        return 1+f(i+1,j)+f(i-1,j)+f(i,j+1)+f(i,j-1);
    }
    public int numEnclaves(int[][] a){
        g=a; n=a.length; m=a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||i==n-1||j==m-1)
                    if(g[i][j]==1) f(i,j);
            }
        }
        int s=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(g[i][j]==1) s+=f(i,j);
        return s;
    }
}
