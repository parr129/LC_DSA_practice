class Solution {
    public int minimumDistance(String w) {
        int[] dp=new int[26];
        int res=0,save=0;
        for(int i=1;i<w.length();i++){
            int b=w.charAt(i-1)-'A';
            int c=w.charAt(i)-'A';
            int dist=Math.abs(b/6-c/6)+Math.abs(b%6-c%6);
            for(int a=0;a<26;a++)
                dp[b]=Math.max(dp[b],dp[a]+dist-(Math.abs(a/6-c/6)+Math.abs(a%6-c%6)));
            save=Math.max(save,dp[b]);
            res+=dist;
        }
        return res-save;
    }
}