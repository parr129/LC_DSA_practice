class Solution {
    public int maxStudents(char[][] a) {
        int m=a.length,n=a[0].length,s=1<<n;
        int[] r=new int[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                r[i]=(r[i]<<1)+(a[i][j]=='.'?1:0);
            }
        }
        int[][] d=new int[m][s];
        for(int i=0;i<m;i++){
            for(int j=0;j<s;j++){
                if((j&r[i])==j&&(j&(j<<1))==0){
                    if(i==0)d[i][j]=Integer.bitCount(j);
                    else{
                        for(int k=0;k<s;k++){
                            if(d[i-1][k]>=0&&(k<<1&j)==0&&((j<<1)&k)==0){
                                d[i][j]=Math.max(d[i][j],d[i-1][k]+Integer.bitCount(j));
                            }
                        }
                    }
                }else d[i][j]=-1;
            }
        }
        int x=0;
        for(int j=0;j<s;j++)x=Math.max(x,d[m-1][j]);
        return x;
    }
}