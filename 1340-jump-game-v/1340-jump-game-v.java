import java.util.*;
class Solution {
    public int maxJumps(int[] a, int d) {
        int n=a.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++)idx[i]=i;
        Arrays.sort(idx,(x,y)->a[x]-a[y]);
        int[] dp=new int[n];
        int r=1;
        for(int j:idx){
            dp[j]=1;
            for(int k=j-1;k>=Math.max(0,j-d);k--){
                if(a[k]>a[j])break;
                dp[j]=Math.max(dp[j],dp[k]+1);
            }
            for(int k=j+1;k<=Math.min(n-1,j+d);k++){
                if(a[k]>a[j])break;
                dp[j]=Math.max(dp[j],dp[k]+1);
            }
            r=Math.max(r,dp[j]);
        }
        return r;
    }
}