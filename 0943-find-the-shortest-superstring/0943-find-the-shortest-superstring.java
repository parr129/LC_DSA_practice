import java.util.*;

class Solution {
    public String shortestSuperstring(String[] w) {
        int n=w.length;
        int[][] o=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int m=Math.min(w[i].length(),w[j].length());
                for(int k=m;k>=0;k--){
                    if(w[i].endsWith(w[j].substring(0,k))){
                        o[i][j]=k;
                        break;
                    }
                }
            }
        }
        int[][] dp=new int[1<<n][n];
        int[][] p=new int[1<<n][n];
        for(int[] d:dp) Arrays.fill(d,1<<30);
        for(int i=0;i<n;i++) dp[1<<i][i]=w[i].length();
        for(int m=0;m<(1<<n);m++){
            for(int i=0;i<n;i++){
                if((m&(1<<i))==0) continue;
                int pm=m^(1<<i);
                if(pm==0) continue;
                for(int j=0;j<n;j++){
                    if((pm&(1<<j))==0) continue;
                    int v=dp[pm][j]+w[i].length()-o[j][i];
                    if(v<dp[m][i]){
                        dp[m][i]=v;
                        p[m][i]=j;
                    }
                }
            }
        }
        int m=(1<<n)-1,cur=0;
        for(int i=1;i<n;i++) if(dp[m][i]<dp[m][cur]) cur=i;
        List<Integer> path=new ArrayList<>();
        while(m>0){
            path.add(cur);
            int t=p[m][cur];
            m^=1<<cur;
            cur=t;
            if(cur==0&&m==0) break;
        }
        Collections.reverse(path);
        StringBuilder sb=new StringBuilder(w[path.get(0)]);
        for(int i=1;i<path.size();i++){
            int a=path.get(i-1),b=path.get(i);
            sb.append(w[b].substring(o[a][b]));
        }
        return sb.toString();
    }
}