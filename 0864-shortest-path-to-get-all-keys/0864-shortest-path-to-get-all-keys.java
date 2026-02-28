import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] g) {
        int m=g.length,n=g[0].length(),sx=0,sy=0,k=0;
        for(int i=0;i<m;i++)for(int j=0;j<n;j++){
            char c=g[i].charAt(j);
            if(c=='@'){sx=i;sy=j;}
            if(c>='a'&&c<='f') k=Math.max(k,c-'a'+1);
        }
        int t=(1<<k)-1;
        Queue<int[]> q=new ArrayDeque<>();
        boolean[][][] v=new boolean[m][n][1<<k];
        q.offer(new int[]{sx,sy,0,0});
        v[sx][sy][0]=true;
        int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] p=q.poll();
            int x=p[0],y=p[1],ms=p[2],st=p[3];
            if(ms==t) return st;
            for(int[] z:d){
                int nx=x+z[0],ny=y+z[1],nm=ms;
                if(nx<0||ny<0||nx>=m||ny>=n) continue;
                char c=g[nx].charAt(ny);
                if(c=='#') continue;
                if(c>='A'&&c<='F'&&(ms>>(c-'A')&1)==0) continue;
                if(c>='a'&&c<='f') nm=ms|(1<<(c-'a'));
                if(!v[nx][ny][nm]){
                    v[nx][ny][nm]=true;
                    q.offer(new int[]{nx,ny,nm,st+1});
                }
            }
        }
        return -1;
    }
}