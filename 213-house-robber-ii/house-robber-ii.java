class Solution {
 int f(int[] a,int l,int r){
  int p=0,c=0;
  for(int i=l;i<r;i++){
   int t=Math.max(c,p+a[i]);
   p=c;
   c=t;
  }
  return c;
 }
 public int rob(int[] a) {
  int n=a.length;
  if(n==1) return a[0];
  return Math.max(f(a,1,n),f(a,0,n-1));
 }
}
