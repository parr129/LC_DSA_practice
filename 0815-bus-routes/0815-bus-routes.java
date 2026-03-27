import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] r,int s,int t){
        if(s==t) return 0;
        Map<Integer,List<Integer>> m=new HashMap<>();
        int n=r.length;
        for(int i=0;i<n;i++){
            for(int x:r[i]){
                m.computeIfAbsent(x,k->new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> vs=new HashSet<>();
        boolean[] vr=new boolean[n];
        q.offer(s);
        vs.add(s);
        int d=0;
        while(!q.isEmpty()){
            int sz=q.size();
            d++;
            while(sz-->0){
                int x=q.poll();
                for(int i:m.getOrDefault(x,new ArrayList<>())){
                    if(vr[i]) continue;
                    vr[i]=true;
                    for(int y:r[i]){
                        if(y==t) return d;
                        if(vs.add(y)) q.offer(y);
                    }
                }
            }
        }
        return -1;
    }
}