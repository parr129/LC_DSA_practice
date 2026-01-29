class Solution {
    int r,c;
    int[][] m,dp;
    public int longestIncreasingPath(int[][] mat){
        m=mat;
        r=mat.length;
        c=mat[0].length;
        dp=new int[r][c];
        int ans=0;
        for(int i=0;i<r;i++)for(int j=0;j<c;j++)ans=Math.max(ans,dfs(i,j));
        return ans;
    }
    int dfs(int i,int j){
        if(dp[i][j]>0)return dp[i][j];
        int v=m[i][j];
        int a=0;
        if(i>0 && m[i-1][j]>v) a=Math.max(a,dfs(i-1,j));
        if(i<r-1 && m[i+1][j]>v) a=Math.max(a,dfs(i+1,j));
        if(j>0 && m[i][j-1]>v) a=Math.max(a,dfs(i,j-1));
        if(j<c-1 && m[i][j+1]>v) a=Math.max(a,dfs(i,j+1));
        return dp[i][j]=a+1;
    }
}
