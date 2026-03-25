import java.util.*;
class Solution {
    public int threeSumClosest(int[] a, int t) {
        Arrays.sort(a);
        int n=a.length,s=a[0]+a[1]+a[2];
        for(int i=0;i<n-2;i++){
            int l=i+1,r=n-1;
            while(l<r){
                int x=a[i]+a[l]+a[r];
                if(Math.abs(x-t)<Math.abs(s-t)) s=x;
                if(x<t) l++;
                else if(x>t) r--;
                else return x;
            }
        }
        return s;
    }
}