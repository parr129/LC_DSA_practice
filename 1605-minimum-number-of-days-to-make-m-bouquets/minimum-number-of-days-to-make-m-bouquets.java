class Solution {
    public int minDays(int[] b, int m, int k) {
        if((long)m*k>b.length) return -1;
        int l=1, r=0;
        for(int v:b) r=Math.max(r,v);
        while(l<r) {
            int d=(l+r)/2;
            int c=0, p=0;
            for(int v:b) {
                if(v<=d) { p++; if(p==k){c++; p=0;} }
                else p=0;
            }
            if(c<m) l=d+1;
            else r=d;
        }
        return l;
    }
}
