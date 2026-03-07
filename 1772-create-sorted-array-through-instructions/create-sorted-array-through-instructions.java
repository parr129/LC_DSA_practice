class Solution{
public int createSortedArray(int[] a){
int m=100001;
int[] t=new int[m];
long r=0;
int mod=1000000007;

for(int x:a){
int l=s(t,x-1);
int g=s(t,m-1)-s(t,x);
r=(r+Math.min(l,g))%mod;
u(t,x,1);
}
return (int)r;
}

int s(int[] t,int i){
int r=0;
for(;i>0;i-=i&-i)r+=t[i];
return r;
}

void u(int[] t,int i,int v){
for(;i<t.length;i+=i&-i)t[i]+=v;
}
}