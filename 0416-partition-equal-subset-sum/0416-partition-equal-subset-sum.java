class Solution {
    public boolean canPartition(int[] a) {
        int s=0;
        for(int v:a) s+=v;
        if((s&1)==1) return false;
        int t=s/2;
        boolean[] d=new boolean[t+1];
        d[0]=true;
        for(int v:a){
            for(int j=t;j>=v;j--){
                d[j]=d[j]||d[j-v];
            }
        }
        return d[t];
    }
}
