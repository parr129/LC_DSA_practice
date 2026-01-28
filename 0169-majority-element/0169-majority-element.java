class Solution{
 public int majorityElement(int[] a){
  int c=0,e=0;
  for(int x:a){
   if(c==0){e=x;c=1;}
   else if(e==x) c++;
   else c--;
  }
  return e;
 }
}
