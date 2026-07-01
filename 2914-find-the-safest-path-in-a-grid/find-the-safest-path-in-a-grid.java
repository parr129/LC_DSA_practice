class Solution {
    int[] dx={1,-1,0,0},dy={0,0,1,-1};

    public int maximumSafenessFactor(List<List<Integer>> g) {
        int n=g.size();
        int[][] d=new int[n][n];
        for(int[] r:d) Arrays.fill(r,-1);
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(g.get(i).get(j)==1){
                    d[i][j]=0;
                    q.offer(new int[]{i,j});
                }

        while(!q.isEmpty()){
            int[] c=q.poll();
            for(int k=0;k<4;k++){
                int x=c[0]+dx[k],y=c[1]+dy[k];
                if(x>=0&&y>=0&&x<n&&y<n&&d[x][y]==-1){
                    d[x][y]=d[c[0]][c[1]]+1;
                    q.offer(new int[]{x,y});
                }
            }
        }

        int l=0,r=2*n;
        while(l<r){
            int m=(l+r+1)/2;
            if(ok(d,m)) l=m;
            else r=m-1;
        }
        return l;
    }

    boolean ok(int[][] d,int v){
        int n=d.length;
        if(d[0][0]<v) return false;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];
        q.offer(new int[]{0,0});
        vis[0][0]=true;
        while(!q.isEmpty()){
            int[] c=q.poll();
            if(c[0]==n-1&&c[1]==n-1) return true;
            for(int k=0;k<4;k++){
                int x=c[0]+dx[k],y=c[1]+dy[k];
                if(x>=0&&y>=0&&x<n&&y<n&&!vis[x][y]&&d[x][y]>=v){
                    vis[x][y]=true;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return false;
    }
}