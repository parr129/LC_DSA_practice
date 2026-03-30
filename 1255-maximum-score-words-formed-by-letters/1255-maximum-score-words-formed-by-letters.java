class Solution {
    int ans=0;
    public int maxScoreWords(String[] w, char[] l, int[] s) {
        int[] c=new int[26];
        for(char x:l)c[x-'a']++;
        f(w,c,s,0,0);
        return ans;
    }
    void f(String[] w,int[] c,int[] s,int i,int cur){
        if(i==w.length){
            ans=Math.max(ans,cur);
            return;
        }
        f(w,c,s,i+1,cur);
        int[] t=new int[26];
        int sc=0;
        boolean ok=true;
        for(char x:w[i].toCharArray()){
            int j=x-'a';
            t[j]++;
            if(t[j]>c[j])ok=false;
            sc+=s[j];
        }
        if(ok){
            for(int j=0;j<26;j++)c[j]-=t[j];
            f(w,c,s,i+1,cur+sc);
            for(int j=0;j<26;j++)c[j]+=t[j];
        }
    }
}