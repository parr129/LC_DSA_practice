import java.util.*;

class MapSum {

    class N{
        N[] c=new N[26];
        int v;
    }

    N r=new N();
    Map<String,Integer> m=new HashMap<>();

    public MapSum(){}

    public void insert(String k,int val){
        int d=val-m.getOrDefault(k,0);
        m.put(k,val);

        N n=r;

        for(char x:k.toCharArray()){
            int i=x-'a';
            if(n.c[i]==null) n.c[i]=new N();
            n=n.c[i];
            n.v+=d;
        }
    }

    public int sum(String p){
        N n=r;

        for(char x:p.toCharArray()){
            int i=x-'a';
            if(n.c[i]==null) return 0;
            n=n.c[i];
        }

        return n.v;
    }
}