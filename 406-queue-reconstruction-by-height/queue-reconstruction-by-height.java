class Solution {
    public int[][] reconstructQueue(int[][] a) {
        java.util.Arrays.sort(a,(x,y)->x[0]==y[0]?x[1]-y[1]:y[0]-x[0]);
        java.util.List<int[]> r=new java.util.ArrayList<>();
        for(int[] e:a)r.add(e[1],e);
        return r.toArray(new int[a.length][2]);
    }
}