class Solution{
    public int checkRecord(int n){
        long m=1000000007;
        long[][][] d=new long[n+1][2][3];
        d[0][0][0]=1;
        for(int i=1;i<=n;i++){
            for(int a=0;a<2;a++)
                for(int l=0;l<3;l++)
                    d[i][a][0]=(d[i][a][0]+d[i-1][a][l])%m;
            for(int l=0;l<3;l++)
                d[i][1][0]=(d[i][1][0]+d[i-1][0][l])%m;
            for(int a=0;a<2;a++)
                for(int l=1;l<3;l++)
                    d[i][a][l]=(d[i][a][l]+d[i-1][a][l-1])%m;
        }
        long s=0;
        for(int a=0;a<2;a++)
            for(int l=0;l<3;l++)
                s=(s+d[n][a][l])%m;
        return (int)s;
    }
}