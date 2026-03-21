class Solution {
    public int atMostNGivenDigitSet(String[] d, int n) {
        String s=""+n;
        int m=s.length(),k=d.length,ans=0;

        for(int i=1;i<m;i++){
            int x=1;
            for(int j=0;j<i;j++) x*=k;
            ans+=x;
        }

        for(int i=0;i<m;i++){
            int c=s.charAt(i)-'0';
            boolean ok=false;

            for(String x:d){
                int v=x.charAt(0)-'0';
                if(v<c){
                    int t=1;
                    for(int j=i+1;j<m;j++) t*=k;
                    ans+=t;
                }
                if(v==c) ok=true;
            }

            if(!ok) return ans;
        }

        return ans+1;
    }
}