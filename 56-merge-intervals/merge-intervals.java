import java.util.*;

class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        List<int[]> l=new ArrayList<>();
        int[] c=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i][0]<=c[1]){
                c[1]=Math.max(c[1],a[i][1]);
            }else{
                l.add(c);
                c=a[i];
            }
        }
        l.add(c);
        return l.toArray(new int[l.size()][]);
    }
}