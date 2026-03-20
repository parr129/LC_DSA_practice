class Solution {
    public int[] countSubgraphsForEachDiameter(int n,int[][] e){
        int[][] d=new int[n][n];
        for(int[] x:d) Arrays.fill(x,100);
        for(int i=0;i<n;i++) d[i][i]=0;
        for(int[] x:e){
            d[x[0]-1][x[1]-1]=1;
            d[x[1]-1][x[0]-1]=1;
        }
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    d[i][j]=Math.min(d[i][j],d[i][k]+d[k][j]);
        int[] r=new int[n-1];
        for(int m=1;m<(1<<n);m++){
            int c=0,ed=0,md=0;
            for(int i=0;i<n;i++){
                if((m&(1<<i))!=0){
                    c++;
                    for(int j=i+1;j<n;j++){
                        if((m&(1<<j))!=0){
                            if(d[i][j]==1) ed++;
                            md=Math.max(md,d[i][j]);
                        }
                    }
                }
            }
            if(ed==c-1&&md>0) r[md-1]++;
        }
        return r;
    }
}