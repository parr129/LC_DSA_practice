class Solution{
public int getMoneyAmount(int n){
int[][] d=new int[n+2][n+2];
for(int l=2;l<=n;l++){
for(int i=1;i+l-1<=n;i++){
int j=i+l-1,m=Integer.MAX_VALUE;
for(int k=i;k<=j;k++){
int c=k+Math.max(k>i?d[i][k-1]:0,k<j?d[k+1][j]:0);
m=Math.min(m,c);
}
d[i][j]=m;
}
}
return d[1][n];
}
}