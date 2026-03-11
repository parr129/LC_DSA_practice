class Solution{
public int numberOfArithmeticSlices(int[] a){
int c=0,r=0;
for(int i=2;i<a.length;i++){
if(a[i]-a[i-1]==a[i-1]-a[i-2])r++;
else r=0;
c+=r;
}
return c;
}
}