class Solution {
    String s1,s2;
    int n;
    Boolean[][][] dp;
    public boolean isScramble(String a,String b){
        s1=a;s2=b;
        n=a.length();
        dp=new Boolean[n][n][n+1];
        return f(0,0,n);
    }
    boolean f(int i,int j,int l){
        if(dp[i][j][l]!=null)return dp[i][j][l];
        if(s1.substring(i,i+l).equals(s2.substring(j,j+l)))return dp[i][j][l]=true;
        for(int k=1;k<l;k++){
            if(f(i,j,k)&&f(i+k,j+k,l-k)
               ||f(i,j+l-k,k)&&f(i+k,j,l-k))
                return dp[i][j][l]=true;
        }
        return dp[i][j][l]=false;
    }
}
