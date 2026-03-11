class Solution{
public int minSubArrayLen(int t,int[] a){
int l=0,s=0,r=Integer.MAX_VALUE;
for(int i=0;i<a.length;i++){
s+=a[i];
while(s>=t){
r=Math.min(r,i-l+1);
s-=a[l++];
}
}
return r==Integer.MAX_VALUE?0:r;
}
}