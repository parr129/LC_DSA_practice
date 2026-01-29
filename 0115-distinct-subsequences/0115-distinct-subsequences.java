class Solution {
    public int numDistinct(String s,String t){
        int n=s.length(),k=t.length();
        int[][] dp=new int[n+1][k+1];
        for(int i=0;i<=n;i++)dp[i][0]=1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=k;j++)
                dp[i][j]=dp[i-1][j]+(s.charAt(i-1)==t.charAt(j-1)?dp[i-1][j-1]:0);
        return dp[n][k];
    }
}
