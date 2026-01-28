class Solution{
 public int minimumTotal(List<List<Integer>> a){
  int n=a.size();
  for(int i=n-2;i>=0;i--){
   for(int j=0;j<=i;j++){
    a.get(i).set(j,a.get(i).get(j)+Math.min(a.get(i+1).get(j),a.get(i+1).get(j+1)));
   }
  }
  return a.get(0).get(0);
 }
}
