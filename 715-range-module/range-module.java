class RangeModule {
    class N{N l,r;int a;boolean v;}
    N r=new N();
    void mdf(N n,int L,int R,int l,int h,int x){
        if(l>R||h<L)return;
        if(L>=l&&R<=h){n.v=x==1; n.a=x; return;}
        int M=(L+R)>>1;
        push(n);
        if(n.l==null)n.l=new N();
        if(n.r==null)n.r=new N();
        mdf(n.l,L,M,l,h,x);
        mdf(n.r,M+1,R,l,h,x);
        n.v = n.l.v && n.r.v;
    }
    boolean qry(N n,int L,int R,int l,int h){
        if(n==null)return false;
        if(l>R||h<L)return true;
        if(L>=l&&R<=h)return n.v;
        int M=(L+R)>>1;
        push(n);
        return qry(n.l,L,M,l,h) && qry(n.r,M+1,R,l,h);
    }
    void push(N n){
        if(n.a!=0){
            if(n.l==null)n.l=new N();
            if(n.r==null)n.r=new N();
            n.l.a=n.r.a=n.a;
            n.l.v=n.r.v = n.a==1;
            n.a=0;
        }
    }
    public void addRange(int l,int h){ mdf(r,1,1000000000,l,h-1,1); }
    public boolean queryRange(int l,int h){ return qry(r,1,1000000000,l,h-1); }
    public void removeRange(int l,int h){ mdf(r,1,1000000000,l,h-1,-1); }
}