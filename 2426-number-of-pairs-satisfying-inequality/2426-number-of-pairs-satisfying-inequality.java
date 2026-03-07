class Solution{
long c;

public long numberOfPairs(int[] a,int[] b,int d){
int n=a.length;
long[] x=new long[n];
for(int i=0;i<n;i++)x[i]=a[i]-b[i];
f(x,0,n-1,d);
return c;
}

void f(long[] a,int l,int r,int d){
if(l>=r)return;
int m=(l+r)/2;
f(a,l,m,d);
f(a,m+1,r,d);

int j=m+1;
for(int i=l;i<=m;i++){
while(j<=r&&a[i]>a[j]+d)j++;
c+=r-j+1;
}

long[] t=new long[r-l+1];
int i=l,k=0;
j=m+1;
while(i<=m&&j<=r)
t[k++]=a[i]<=a[j]?a[i++]:a[j++];
while(i<=m)t[k++]=a[i++];
while(j<=r)t[k++]=a[j++];
System.arraycopy(t,0,a,l,t.length);
}
}