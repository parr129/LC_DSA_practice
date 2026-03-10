class Solution {
    public List<List<Integer>> kSmallestPairs(int[] a,int[] b,int k){
        List<List<Integer>> r=new ArrayList<>();
        if(a.length==0||b.length==0) return r;
        PriorityQueue<int[]> q=new PriorityQueue<>((x,y)->x[0]-y[0]);
        for(int i=0;i<Math.min(a.length,k);i++)
            q.offer(new int[]{a[i]+b[0],i,0});
        while(k-->0&&!q.isEmpty()){
            int[] t=q.poll();
            int i=t[1],j=t[2];
            r.add(Arrays.asList(a[i],b[j]));
            if(j+1<b.length)
                q.offer(new int[]{a[i]+b[j+1],i,j+1});
        }
        return r;
    }
}