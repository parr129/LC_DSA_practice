import java.util.*;

class Solution {

    class N{
        N[] c=new N[26];
        boolean e;
    }

    public String replaceWords(List<String> d,String s){
        N r=new N();

        for(String w:d){
            N n=r;
            for(char x:w.toCharArray()){
                int i=x-'a';
                if(n.c[i]==null) n.c[i]=new N();
                n=n.c[i];
            }
            n.e=true;
        }

        String[] a=s.split(" ");
        StringBuilder b=new StringBuilder();

        for(int i=0;i<a.length;i++){
            if(i>0) b.append(" ");
            b.append(f(r,a[i]));
        }

        return b.toString();
    }

    String f(N r,String w){
        N n=r;
        StringBuilder t=new StringBuilder();

        for(char x:w.toCharArray()){
            int i=x-'a';
            if(n.c[i]==null) return w;
            t.append(x);
            n=n.c[i];
            if(n.e) return t.toString();
        }

        return w;
    }
}