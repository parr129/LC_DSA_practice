class Solution {
    public int[] findPeakGrid(int[][] m) {
        int r=0, c=m[0].length-1, R=m.length;
        int l=0;
        while(l<=c){
            int mid=(l+c)/2, mi=0;
            for(int i=1;i<R;i++) if(m[i][mid]>m[mi][mid]) mi=i;
            int L=mid>0?m[mi][mid-1]:-1;
            int Rv=mid+1<m[0].length?m[mi][mid+1]:-1;
            if(m[mi][mid]>=L && m[mi][mid]>=Rv) return new int[]{mi,mid};
            if(Rv>m[mi][mid]) l=mid+1;
            else c=mid-1;
        }
        return new int[]{0,0};
    }
}
