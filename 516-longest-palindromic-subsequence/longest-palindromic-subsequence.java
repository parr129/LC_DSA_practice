class Solution{
    public int longestPalindromeSubseq(String s){
        int n=s.length();
        int[][] d=new int[n][n];
        for(int i=n-1;i>=0;i--){
            d[i][i]=1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)) d[i][j]=2+(i+1<=j-1?d[i+1][j-1]:0);
                else d[i][j]=Math.max(d[i+1][j],d[i][j-1]);
            }
        }
        return d[0][n-1];
    }
}
