import java.util.*;
class Solution {
    public int maxChunksToSorted(int[] a) {
        int n = a.length;
        int[] lmax = new int[n];
        int[] rmin = new int[n+1];
        lmax[0] = a[0];
        for(int i=1;i<n;i++) lmax[i] = Math.max(lmax[i-1], a[i]);
        rmin[n] = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--) rmin[i] = Math.min(rmin[i+1], a[i]);
        int c=0;
        for(int i=0;i<n;i++){
            if(lmax[i] <= rmin[i+1]) c++;
        }
        return c;
    }
}