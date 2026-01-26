class Solution {
 public int rob(int[] a) {
  int p=0,c=0;
  for(int x:a){
   int t=Math.max(c,p+x);
   p=c;
   c=t;
  }
  return c;
 }
}
