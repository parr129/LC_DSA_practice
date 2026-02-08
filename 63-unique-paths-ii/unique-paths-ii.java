class Solution{
 public int uniquePathsWithObstacles(int[][] g){
  int m=g.length,n=g[0].length;
  int[][] f=new int[m][n];
  if(g[0][0]==0) f[0][0]=1;
  for(int i=0;i<m;i++){
   for(int j=0;j<n;j++){
    if(g[i][j]==1) continue;
    if(i>0) f[i][j]+=f[i-1][j];
    if(j>0) f[i][j]+=f[i][j-1];
   }
  }
  return f[m-1][n-1];
 }
}
