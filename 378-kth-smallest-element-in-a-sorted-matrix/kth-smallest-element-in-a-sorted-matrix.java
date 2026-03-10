class Solution {
    public int kthSmallest(int[][] m, int k) {
        int n=m.length;
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++) q.offer(new int[]{m[i][0],i,0});
        int r=0;
        while(k-->0){
            int[] t=q.poll();
            r=t[0];
            int i=t[1],j=t[2];
            if(j+1<n) q.offer(new int[]{m[i][j+1],i,j+1});
        }
        return r;
    }
}