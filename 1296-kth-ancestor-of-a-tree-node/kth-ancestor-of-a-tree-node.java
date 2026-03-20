class TreeAncestor {
    int[][] p;
    public TreeAncestor(int n,int[] par){
        int m=20;
        p=new int[m][n];
        p[0]=par;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int x=p[i-1][j];
                p[i][j]=x==-1?-1:p[i-1][x];
            }
        }
    }
    public int getKthAncestor(int u,int k){
        int i=0;
        while(k>0&&u!=-1){
            if((k&1)==1) u=p[i][u];
            k>>=1;
            i++;
        }
        return u;
    }
}