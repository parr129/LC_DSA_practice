class Solution {
    public boolean searchMatrix(int[][] m,int t){
        int r=m.length,c=m[0].length,l=0,h=r*c-1;
        while(l<=h){
            int mid=(l+h)/2;
            int v=m[mid/c][mid%c];
            if(v==t) return true;
            if(v<t) l=mid+1; else h=mid-1;
        }
        return false;
    }
}
