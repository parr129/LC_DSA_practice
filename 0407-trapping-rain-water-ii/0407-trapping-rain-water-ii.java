class Solution {
    public int trapRainWater(int[][] h) {
        int m=h.length,n=h[0].length;
        boolean[][] v=new boolean[m][n];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<m;i++){
            q.offer(new int[]{h[i][0],i,0});
            q.offer(new int[]{h[i][n-1],i,n-1});
            v[i][0]=v[i][n-1]=true;
        }
        for(int j=1;j<n-1;j++){
            q.offer(new int[]{h[0][j],0,j});
            q.offer(new int[]{h[m-1][j],m-1,j});
            v[0][j]=v[m-1][j]=true;
        }
        int r=0;
        int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] t=q.poll();
            for(int[] x:d){
                int i=t[1]+x[0],j=t[2]+x[1];
                if(i>=0&&j>=0&&i<m&&j<n&&!v[i][j]){
                    v[i][j]=true;
                    r+=Math.max(0,t[0]-h[i][j]);
                    q.offer(new int[]{Math.max(t[0],h[i][j]),i,j});
                }
            }
        }
        return r;
    }
}