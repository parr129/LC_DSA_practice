class Solution{
    int f(int x,int[] p){
        if(p[x]!=x) p[x]=f(p[x],p);
        return p[x];
    }
    public int makeConnected(int n,int[][] c){
        if(c.length<n-1) return -1;
        int[] p=new int[n];
        for(int i=0;i<n;i++) p[i]=i;
        for(int[] e:c){
            int a=f(e[0],p),b=f(e[1],p);
            if(a!=b) p[a]=b;
        }
        int cnt=0;
        for(int i=0;i<n;i++) if(f(i,p)==i) cnt++;
        return cnt-1;
    }
}
