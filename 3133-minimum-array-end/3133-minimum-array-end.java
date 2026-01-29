class Solution {
    public long minimumArrayEnd(int n,long x){
        long ans=x;
        long v=n-1;
        for(int i=0;i<63 && v>0;i++){
            if(((x>>i)&1)==0){
                ans|=((v&1L)<<i);
                v>>=1;
            }
        }
        return ans|(v<<63>>63<<63);
    }
}
