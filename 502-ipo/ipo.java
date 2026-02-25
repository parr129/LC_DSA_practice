import java.util.*;
class Solution {
    public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
        int n=p.length;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){a[i]=new int[]{c[i],p[i]};}
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        for(int j=0;j<k;j++){
            while(i<n && a[i][0]<=w){q.add(a[i][1]);i++;}
            if(q.isEmpty())break;
            w+=q.poll();
        }
        return w;
    }
}