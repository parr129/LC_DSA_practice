class Solution {
    public int[][] floodFill(int[][] a, int r, int c, int n) {
        int o=a[r][c];
        if(o==n)return a;
        f(a,r,c,o,n);
        return a;
    }
    void f(int[][] a,int i,int j,int o,int n){
        if(i<0||j<0||i==a.length||j==a[0].length||a[i][j]!=o)return;
        a[i][j]=n;
        f(a,i+1,j,o,n);
        f(a,i-1,j,o,n);
        f(a,i,j+1,o,n);
        f(a,i,j-1,o,n);
    }
}
