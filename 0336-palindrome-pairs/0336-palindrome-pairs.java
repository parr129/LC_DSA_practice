import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] w){
        Map<String,Integer> m=new HashMap<>();
        List<List<Integer>> r=new ArrayList<>();
        for(int i=0;i<w.length;i++)
            m.put(w[i],i);

        for(int i=0;i<w.length;i++){
            String s=w[i];
            for(int j=0;j<=s.length();j++){
                String a=s.substring(0,j);
                String b=s.substring(j);
                if(p(a)){
                    String rb=new StringBuilder(b).reverse().toString();
                    if(m.containsKey(rb)&&m.get(rb)!=i)
                        r.add(Arrays.asList(m.get(rb),i));
                }
                if(b.length()>0&&p(b)){
                    String ra=new StringBuilder(a).reverse().toString();
                    if(m.containsKey(ra)&&m.get(ra)!=i)
                        r.add(Arrays.asList(i,m.get(ra)));
                }
            }
        }
        return r;
    }

    boolean p(String s){
        int i=0,j=s.length()-1;
        while(i<j)
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        return true;
    }
}