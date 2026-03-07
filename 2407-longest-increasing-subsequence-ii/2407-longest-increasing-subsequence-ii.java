class Solution{
public int lengthOfLIS(int[] a,int k){
int n=a.length;
int m=100001;
int[] t=new int[m*4];
int r=0;

for(int x:a){
int l=Math.max(1,x-k);
int v=q(t,1,1,m,l,x-1)+1;
u(t,1,1,m,x,v);
r=Math.max(r,v);
}
return r;
}

int q(int[] t,int i,int l,int r,int ql,int qr){
if(ql>r||qr<l)return 0;
if(ql<=l&&r<=qr)return t[i];
int m=(l+r)/2;
return Math.max(q(t,i*2,l,m,ql,qr),q(t,i*2+1,m+1,r,ql,qr));
}

void u(int[] t,int i,int l,int r,int p,int v){
if(l==r){t[i]=Math.max(t[i],v);return;}
int m=(l+r)/2;
if(p<=m)u(t,i*2,l,m,p,v);
else u(t,i*2+1,m+1,r,p,v);
t[i]=Math.max(t[i*2],t[i*2+1]);
}
}