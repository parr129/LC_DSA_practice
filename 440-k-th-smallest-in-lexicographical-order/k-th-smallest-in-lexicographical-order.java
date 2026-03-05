class Solution {

    public int findKthNumber(int n,int k){
        int c=1;
        k--;

        while(k>0){
            long s=g(n,c,c+1);
            if(s<=k){
                c++;
                k-=s;
            }else{
                c*=10;
                k--;
            }
        }
        return c;
    }

    long g(long n,long a,long b){
        long r=0;
        while(a<=n){
            r+=Math.min(n+1,b)-a;
            a*=10;
            b*=10;
        }
        return r;
    }
}