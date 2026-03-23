class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        Map<String,List<String>> m=new HashMap<>();
        for(String x:s){
            char[] c=x.toCharArray();
            Arrays.sort(c);
            String k=new String(c);
            m.computeIfAbsent(k,a->new ArrayList<>()).add(x);
        }
        return new ArrayList<>(m.values());
    }
}