import java.util.*;
class Solution {
    LinkedList<String> r=new LinkedList<>();
    public List<String> findItinerary(List<List<String>> t) {
        Map<String, PriorityQueue<String>> m=new HashMap<>();
        for(List<String> p:t){
            m.computeIfAbsent(p.get(0),a->new PriorityQueue<>()).add(p.get(1));
        }
        dfs("JFK",m);
        return r;
    }
    void dfs(String u, Map<String,PriorityQueue<String>> m){
        PriorityQueue<String> q=m.get(u);
        while(q!=null && !q.isEmpty()){
            String v=q.poll();
            dfs(v,m);
        }
        r.addFirst(u);
    }
}