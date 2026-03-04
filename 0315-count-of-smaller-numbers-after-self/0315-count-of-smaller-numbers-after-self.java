class Solution {
    class T{int v,c;T l,r;T(int x){v=x;}}
    public java.util.List<Integer> countSmaller(int[] a) {
        int n=a.length;
        Integer[] r=new Integer[n];
        T root=null;
        for(int i=n-1;i>=0;i--){
            int x=a[i],s=0;
            if(root==null)root=new T(x);
            else{
                T c=root;
                while(true){
                    if(x<=c.v){
                        c.c++;
                        if(c.l==null){c.l=new T(x);break;}
                        c=c.l;
                    } else{
                        s+=c.c+1;
                        if(c.r==null){c.r=new T(x);break;}
                        c=c.r;
                    }
                }
            }
            r[i]=s;
        }
        return java.util.Arrays.asList(r);
    }
}