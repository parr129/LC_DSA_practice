import java.util.*;
class Solution {
    public int oddEvenJumps(int[] A) {
        int n=A.length;
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        boolean[] od=new boolean[n];
        boolean[] ev=new boolean[n];
        od[n-1]=true;
        ev[n-1]=true;
        tm.put(A[n-1],n-1);
        int c=1;
        for(int i=n-2;i>=0;i--){
            Integer hi=tm.ceilingKey(A[i]);
            Integer lo=tm.floorKey(A[i]);
            if(hi!=null)od[i]=ev[tm.get(hi)];
            if(lo!=null)ev[i]=od[tm.get(lo)];
            if(od[i])c++;
            tm.put(A[i],i);
        }
        return c;
    }
}