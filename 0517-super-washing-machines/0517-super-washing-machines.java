class Solution{
    public int findMinMoves(int[] a){
        int s=0;
        for(int x:a)s+=x;
        if(s%a.length!=0)return -1;
        int t=s/a.length,r=0,m=0;
        for(int x:a){
            r+=x-t;
            m=Math.max(m,Math.max(Math.abs(r),x-t));
        }
        return m;
    }
}