class Solution {
    public int shortestPathLength(int[][] g) {
        int n=g.length, t=(1<<n)-1;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] v=new boolean[n][1<<n];
        for(int i=0;i<n;i++){
            q.offer(new int[]{i,1<<i});
            v[i][1<<i]=true;
        }
        int d=0;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                int[] c=q.poll();
                if(c[1]==t) return d;
                for(int nx:g[c[0]]){
                    int m=c[1]|(1<<nx);
                    if(!v[nx][m]){
                        v[nx][m]=true;
                        q.offer(new int[]{nx,m});
                    }
                }
            }
            d++;
        }
        return -1;
    }
}