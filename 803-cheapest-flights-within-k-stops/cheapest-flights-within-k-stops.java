class Solution {
    public int findCheapestPrice(int n,int[][] f,int s,int d,int k) {
        List<int[]>[] g=new ArrayList[n];
        for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int[] e:f) g[e[0]].add(new int[]{e[1],e[2]});
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{s,0});
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s]=0;
        int st=0;
        while(!q.isEmpty()&&st<=k){
            int z=q.size();
            int[] tmp=dist.clone();
            while(z-->0){
                int[] cur=q.poll();
                int u=cur[0],c=cur[1];
                for(int[] e:g[u]){
                    int v=e[0],w=e[1];
                    if(c+w<tmp[v]){
                        tmp[v]=c+w;
                        q.offer(new int[]{v,tmp[v]});
                    }
                }
            }
            dist=tmp;
            st++;
        }
        return dist[d]==Integer.MAX_VALUE?-1:dist[d];
    }
}
