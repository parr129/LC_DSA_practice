class Solution{
    int[][][] d=new int[101][101][101];
    public int removeBoxes(int[] b){
        return f(b,0,b.length-1,0);
    }
    int f(int[] b,int l,int r,int k){
        if(l>r)return 0;
        while(l<r&&b[r]==b[r-1]){r--;k++;}
        if(d[l][r][k]!=0)return d[l][r][k];
        int a=f(b,l,r-1,0)+(k+1)*(k+1);
        for(int i=l;i<r;i++)
            if(b[i]==b[r])
                a=Math.max(a,f(b,l,i,k+1)+f(b,i+1,r-1,0));
        return d[l][r][k]=a;
    }
}