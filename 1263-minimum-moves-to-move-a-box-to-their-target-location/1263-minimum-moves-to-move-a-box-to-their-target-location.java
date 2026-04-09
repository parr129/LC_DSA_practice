import java.util.*;

class Solution {
    int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
    
    public int minPushBox(char[][] g) {
        int m=g.length,n=g[0].length;
        int bx=0,by=0,sx=0,sy=0,tx=0,ty=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]=='B'){bx=i;by=j;}
                if(g[i][j]=='S'){sx=i;sy=j;}
                if(g[i][j]=='T'){tx=i;ty=j;}
            }
        }
        
        Deque<int[]> q=new ArrayDeque<>();
        Set<String> v=new HashSet<>();
        q.offer(new int[]{bx,by,sx,sy,0});
        v.add(bx+","+by+","+sx+","+sy);
        
        while(!q.isEmpty()){
            int[] c=q.poll();
            int x=c[0],y=c[1],px=c[2],py=c[3],k=c[4];
            
            if(x==tx && y==ty) return k;
            
            for(int i=0;i<4;i++){
                int nbx=x+d[i][0],nby=y+d[i][1];
                int reqx=x-d[i][0],reqy=y-d[i][1];
                
                if(!ok(nbx,nby,g) || !ok(reqx,reqy,g)) continue;
                
                if(!reach(px,py,reqx,reqy,x,y,g)) continue;
                
                String s=nbx+","+nby+","+x+","+y;
                if(v.contains(s)) continue;
                v.add(s);
                
                q.offer(new int[]{nbx,nby,x,y,k+1});
            }
        }
        
        return -1;
    }
    
    boolean ok(int x,int y,char[][] g){
        return x>=0 && y>=0 && x<g.length && y<g[0].length && g[x][y]!='#';
    }
    
    boolean reach(int sx,int sy,int tx,int ty,int bx,int by,char[][] g){
        int m=g.length,n=g[0].length;
        Queue<int[]> q=new ArrayDeque<>();
        boolean[][] v=new boolean[m][n];
        q.offer(new int[]{sx,sy});
        v[sx][sy]=true;
        
        while(!q.isEmpty()){
            int[] c=q.poll();
            if(c[0]==tx && c[1]==ty) return true;
            
            for(int[] e:d){
                int nx=c[0]+e[0],ny=c[1]+e[1];
                if(nx<0||ny<0||nx>=m||ny>=n||v[nx][ny]||g[nx][ny]=='#'||(nx==bx&&ny==by)) continue;
                v[nx][ny]=true;
                q.offer(new int[]{nx,ny});
            }
        }
        
        return false;
    }
}