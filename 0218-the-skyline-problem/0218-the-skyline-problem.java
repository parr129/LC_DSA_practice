import java.util.*;
class Solution {
    public List<List<Integer>> getSkyline(int[][] b) {
        List<int[]> e=new ArrayList<>();
        for(int[] x:b){
            e.add(new int[]{x[0],-x[2]});
            e.add(new int[]{x[1],x[2]});
        }
        Collections.sort(e,(a,b1)->{
            if(a[0]!=b1[0])return a[0]-b1[0];
            return a[1]-b1[1];
        });
        List<List<Integer>> r=new ArrayList<>();
        TreeMap<Integer,Integer> m=new TreeMap<>(Collections.reverseOrder());
        m.put(0,1);
        int p=0;
        for(int[] x:e){
            if(x[1]<0){
                m.put(-x[1],m.getOrDefault(-x[1],0)+1);
            } else {
                int c=m.get(x[1]);
                if(c==1)m.remove(x[1]);
                else m.put(x[1],c-1);
            }
            int c2=m.firstKey();
            if(c2!=p){
                r.add(Arrays.asList(x[0],c2));
                p=c2;
            }
        }
        return r;
    }
}