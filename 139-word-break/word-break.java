class Solution {
    public boolean wordBreak(String s, List<String> w) {
        Set<String> set=new HashSet<>(w);
        boolean[] d=new boolean[s.length()+1];
        d[0]=true;
        for(int i=1;i<=s.length();i++)
            for(int j=0;j<i;j++)
                if(d[j]&&set.contains(s.substring(j,i)))d[i]=true;
        return d[s.length()];
    }
}
