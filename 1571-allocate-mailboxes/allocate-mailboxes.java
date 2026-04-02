class Solution{
    public int minDistance(int[] h,int k){
        java.util.Arrays.sort(h);
        int n=h.length;
        int[][] c=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++){
                int m=(i+j)/2;
                for(int t=i;t<=j;t++)c[i][j]+=Math.abs(h[t]-h[m]);
            }
        int[][] dp=new int[n][k+1];
        for(int[] r:dp)java.util.Arrays.fill(r,1000000);
        for(int i=0;i<n;i++)dp[i][1]=c[0][i];
        for(int i=0;i<n;i++)
            for(int j=2;j<=k;j++)
                for(int p=0;p<i;p++)
                    dp[i][j]=Math.min(dp[i][j],dp[p][j-1]+c[p+1][i]);
        return dp[n-1][k];
    }
}