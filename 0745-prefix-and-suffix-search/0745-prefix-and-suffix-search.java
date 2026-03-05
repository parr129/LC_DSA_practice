import java.util.*;

class WordFilter {

    Map<String,Integer> m=new HashMap<>();

    public WordFilter(String[] w){
        for(int i=0;i<w.length;i++){
            String s=w[i];
            int n=s.length();
            for(int p=0;p<=n;p++){
                String a=s.substring(0,p);
                for(int q=0;q<=n;q++){
                    String b=s.substring(n-q);
                    m.put(a+"#"+b,i);
                }
            }
        }
    }

    public int f(String p,String s){
        return m.getOrDefault(p+"#"+s,-1);
    }
}