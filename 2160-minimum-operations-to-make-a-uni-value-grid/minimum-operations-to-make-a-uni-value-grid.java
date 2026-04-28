class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> a = new ArrayList<>();
        
        for (int[] r : grid)
            for (int v : r)
                a.add(v);
        
        Collections.sort(a);
        
        for (int v : a)
            if ((v - a.get(0)) % x != 0)
                return -1;
        
        int median = a.get(a.size() / 2);
        int ans = 0;
        
        for (int v : a)
            ans += Math.abs(v - median) / x;
        
        return ans;
    }
}