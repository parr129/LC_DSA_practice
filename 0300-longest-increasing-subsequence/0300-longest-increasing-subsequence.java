class Solution {
 public int lengthOfLIS(int[] a) {
  int[] b=new int[a.length];
  int n=0;
  for(int x:a){
   int l=0,r=n;
   while(l<r){
    int m=(l+r)/2;
    if(b[m]<x) l=m+1;
    else r=m;
   }
   b[l]=x;
   if(l==n) n++;
  }
  return n;
 }
}
