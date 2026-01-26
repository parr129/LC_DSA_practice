class Solution {
 public int[] productExceptSelf(int[] a) {
  int n=a.length;
  int[] r=new int[n];
  int p=1;
  for(int i=0;i<n;i++){
   r[i]=p;
   p*=a[i];
  }
  int s=1;
  for(int i=n-1;i>=0;i--){
   r[i]*=s;
   s*=a[i];
  }
  return r;
 }
}
