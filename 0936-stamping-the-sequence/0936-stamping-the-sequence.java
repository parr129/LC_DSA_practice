class Solution {
    boolean ok(char[] t,char[] s,int i){
        boolean f=false;
        for(int j=0;j<s.length;j++){
            if(t[i+j]=='?') continue;
            if(t[i+j]!=s[j]) return false;
            f=true;
        }
        return f;
    }

    int ch(char[] t,int i,int m){
        int c=0;
        for(int j=0;j<m;j++){
            if(t[i+j]!='?'){
                t[i+j]='?';
                c++;
            }
        }
        return c;
    }

    public int[] movesToStamp(String s,String tt){
        char[] t=tt.toCharArray(),st=s.toCharArray();
        int n=t.length,m=st.length;
        boolean[] v=new boolean[n];
        java.util.List<Integer> r=new java.util.ArrayList<>();
        int cnt=0;

        while(cnt<n){
            boolean f=false;
            for(int i=0;i<=n-m;i++){
                if(!v[i] && ok(t,st,i)){
                    cnt+=ch(t,i,m);
                    v[i]=true;
                    f=true;
                    r.add(i);
                    if(cnt==n) break;
                }
            }
            if(!f) return new int[0];
        }

        int[] ans=new int[r.size()];
        for(int i=0;i<r.size();i++) ans[i]=r.get(r.size()-1-i);
        return ans;
    }
}