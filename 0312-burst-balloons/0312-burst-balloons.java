class Solution {
    public int maxCoins(int[] a){
        int n=a.length;
        int[] b=new int[n+2];
        for(int i=0;i<n;i++)b[i+1]=a[i];
        b[0]=1;
        b[n+1]=1;
        int[][] dp=new int[n+2][n+2];
        for(int len=2;len<n+2;len++)
            for(int i=0;i+len<n+2;i++){
                int j=i+len;
                for(int k=i+1;k<j;k++)
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+b[i]*b[k]*b[j]+dp[k][j]);
            }
        return dp[0][n+1];
    }
}
