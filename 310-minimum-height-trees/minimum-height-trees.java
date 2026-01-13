import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] e) {
        if (n == 1) return Arrays.asList(0);
        
        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new HashSet<>());
        
        for (int[] x : e) {
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }
        
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (g.get(i).size() == 1) l.add(i);
        
        while (n > 2) {
            n -= l.size();
            List<Integer> nl = new ArrayList<>();
            for (int x : l) {
                int y = g.get(x).iterator().next();
                g.get(y).remove(x);
                if (g.get(y).size() == 1) nl.add(y);
            }
            l = nl;
        }
        
        return l;
    }
}
