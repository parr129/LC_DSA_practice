class Solution {
    public int smallestDivisor(int[] a, int t) {
        int l=1, r=1000000;
        while(l<r) {
            int m=(l+r)/2;
            long s=0;
            for(int v:a) s+=(v+m-1)/m;
            if(s>t) l=m+1;
            else r=m;
        }
        return l;
    }
}
