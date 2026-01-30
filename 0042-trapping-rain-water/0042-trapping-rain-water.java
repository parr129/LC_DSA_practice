class Solution {
    public int trap(int[] h){
        int l=0,r=h.length-1,lv=0,rv=0,res=0;
        while(l<r){
            if(h[l]<h[r]){
                lv=Math.max(lv,h[l]);
                res+=lv-h[l++];
            }else{
                rv=Math.max(rv,h[r]);
                res+=rv-h[r--];
            }
        }
        return res;
    }
}
