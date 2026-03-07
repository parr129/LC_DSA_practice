class Solution{
public long goodTriplets(int[] a,int[] b){
int n=a.length;
int[] p=new int[n];
for(int i=0;i<n;i++)p[a[i]]=i;

int[] x=new int[n];
for(int i=0;i<n;i++)x[i]=p[b[i]];

int[] t=new int[n+2];
long[] l=new long[n];
for(int i=0;i<n;i++){
l[i]=s(t,x[i]);
u(t,x[i]+1,1);
}

t=new int[n+2];
long r=0;
for(int i=n-1;i>=0;i--){
long y=s(t,n)-s(t,x[i]+1);
r+=l[i]*y;
u(t,x[i]+1,1);
}
return r;
}

long s(int[] t,int i){
long r=0;
for(;i>0;i-=i&-i)r+=t[i];
return r;
}

void u(int[] t,int i,int v){
for(;i<t.length;i+=i&-i)t[i]+=v;
}
}