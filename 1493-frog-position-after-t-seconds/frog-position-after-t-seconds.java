class Solution {
    public double frogPosition(int n,int[][] e,int t,int target){
        List<Integer>[] g=new ArrayList[n+1];
        for(int i=1;i<=n;i++) g[i]=new ArrayList<>();
        for(int[] x:e){
            g[x[0]].add(x[1]);
            g[x[1]].add(x[0]);
        }
        Queue<int[]> q=new LinkedList<>();
        boolean[] v=new boolean[n+1];
        q.offer(new int[]{1,1});
        v[1]=true;
        double[] p=new double[n+1];
        p[1]=1.0;
        int time=0;
        while(!q.isEmpty()&&time<t){
            int s=q.size();
            while(s-->0){
                int[] c=q.poll();
                int u=c[0];
                int cnt=0;
                for(int y:g[u]) if(!v[y]) cnt++;
                if(cnt==0) continue;
                for(int y:g[u]){
                    if(!v[y]){
                        v[y]=true;
                        p[y]=p[u]/cnt;
                        q.offer(new int[]{y,0});
                    }
                }
                p[u]=0;
            }
            time++;
        }
        return p[target];
    }
}