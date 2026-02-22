import java.util.*;

class Solution {
    Map<String,Integer> m=new HashMap<>();
    int[][] a;

    public int minStickers(String[] s,String t){
        int n=s.length;
        a=new int[n][26];
        for(int i=0;i<n;i++)
            for(char c:s[i].toCharArray())
                a[i][c-'a']++;
        m.put("",0);
        return f(t);
    }

    int f(String t){
        if(m.containsKey(t)) return m.get(t);
        int[] b=new int[26];
        for(char c:t.toCharArray()) b[c-'a']++;
        int r=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i][t.charAt(0)-'a']==0) continue;
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<26;j++)
                if(b[j]>0)
                    for(int k=0;k<Math.max(0,b[j]-a[i][j]);k++)
                        sb.append((char)('a'+j));
            String s=sb.toString();
            int x=f(s);
            if(x!=-1) r=Math.min(r,1+x);
        }
        m.put(t,r==Integer.MAX_VALUE?-1:r);
        return m.get(t);
    }
}