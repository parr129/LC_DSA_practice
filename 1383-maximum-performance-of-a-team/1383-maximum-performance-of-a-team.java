class Solution{
    public int maxPerformance(int n,int[] s,int[] e,int k){
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){a[i][0]=e[i];a[i][1]=s[i];}
        java.util.Arrays.sort(a,(x,y)->y[0]-x[0]);
        java.util.PriorityQueue<Integer> q=new java.util.PriorityQueue<>();
        long sum=0,res=0,mod=1000000007;
        for(int[] x:a){
            if(q.size()==k)sum-=q.poll();
            q.offer(x[1]);
            sum+=x[1];
            res=Math.max(res,sum*x[0]);
        }
        return (int)(res%mod);
    }
}