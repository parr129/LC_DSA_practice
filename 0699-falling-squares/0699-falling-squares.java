import java.util.*;
class Solution {
    class N{N l,r;int v,a;}
    N r=new N();
    int q(N n,int L,int R,int l,int h){
        if(n==null||l>R||h<L)return 0;
        if(L>=l&&R<=h)return n.v;
        int m=(L+R)>>1;
        push(n);
        return Math.max(q(n.l,L,m,l,h),q(n.r,m+1,R,l,h));
    }
    void u(N n,int L,int R,int l,int h,int val){
        if(l>R||h<L)return;
        if(L>=l&&R<=h){n.v=val;n.a=val;return;}
        int m=(L+R)>>1;
        push(n);
        if(n.l==null)n.l=new N();
        if(n.r==null)n.r=new N();
        u(n.l,L,m,l,h,val);
        u(n.r,m+1,R,l,h,val);
        n.v=Math.max(n.l.v,n.r.v);
    }
    void push(N n){
        if(n.a!=0){
            if(n.l==null)n.l=new N();
            if(n.r==null)n.r=new N();
            n.l.v=n.l.a=n.a;
            n.r.v=n.r.a=n.a;
            n.a=0;
        }
    }
    public List<Integer> fallingSquares(int[][] p){
        List<Integer> o=new ArrayList<>();
        int mx=0;
        for(int[] a:p){
            int l=a[0],s=a[1],h=l+s-1;
            int b=q(r,0,1000000000,l,h);
            int nh=b+s;
            u(r,0,1000000000,l,h,nh);
            mx=Math.max(mx,nh);
            o.add(mx);
        }
        return o;
    }
}