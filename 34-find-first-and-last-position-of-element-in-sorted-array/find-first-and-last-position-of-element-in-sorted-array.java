class Solution {
    public int[] searchRange(int[] a, int t) {
        int l=f(a,t), r=g(a,t);
        return new int[]{l,r};
    }
    int f(int[] a,int t){
        int l=0,r=a.length-1,ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(a[m]>=t){
                if(a[m]==t) ans=m;
                r=m-1;
            }else l=m+1;
        }
        return ans;
    }
    int g(int[] a,int t){
        int l=0,r=a.length-1,ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(a[m]<=t){
                if(a[m]==t) ans=m;
                l=m+1;
            }else r=m-1;
        }
        return ans;
    }
}