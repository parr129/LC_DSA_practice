class Solution {
    public int findLength(int[] a, int[] b) {
        int n=a.length,m=b.length,ans=0;
        int[][] d=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1]){
                    d[i][j]=d[i-1][j-1]+1;
                    ans=Math.max(ans,d[i][j]);
                }
            }
        }
        return ans;
    }
}