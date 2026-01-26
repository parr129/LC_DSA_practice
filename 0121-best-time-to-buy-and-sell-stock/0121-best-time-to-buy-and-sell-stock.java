class Solution {
 public int maxProfit(int[] p) {
  int m=p[0], r=0;
  for(int i=1;i<p.length;i++){
   if(p[i]<m) m=p[i];
   else if(p[i]-m>r) r=p[i]-m;
  }
  return r;
 }
}
