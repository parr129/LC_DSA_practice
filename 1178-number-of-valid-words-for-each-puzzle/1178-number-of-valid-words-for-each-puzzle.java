class Solution {
    public List<Integer> findNumOfValidWords(String[] w, String[] p) {
        Map<Integer,Integer> m=new HashMap<>();
        for(String s:w){
            int b=0;
            for(char c:s.toCharArray())b|=1<<(c-'a');
            if(Integer.bitCount(b)<=7)m.put(b,m.getOrDefault(b,0)+1);
        }
        List<Integer> r=new ArrayList<>();
        for(String s:p){
            int f=1<<(s.charAt(0)-'a');
            int b=0;
            for(char c:s.toCharArray())b|=1<<(c-'a');
            int sub=b,ans=0;
            while(sub>0){
                if((sub&f)!=0)ans+=m.getOrDefault(sub,0);
                sub=(sub-1)&b;
            }
            r.add(ans);
        }
        return r;
    }
}