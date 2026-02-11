class Solution {
    String[] m = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> r = new ArrayList<>();
    public List<String> letterCombinations(String d) {
        if(d==null||d.length()==0) return r;
        go("",d,0);
        return r;
    }
    void go(String s,String d,int i){
        if(i==d.length()){r.add(s);return;}
        for(char c:m[d.charAt(i)-'0'].toCharArray()) go(s+c,d,i+1);
    }
}
