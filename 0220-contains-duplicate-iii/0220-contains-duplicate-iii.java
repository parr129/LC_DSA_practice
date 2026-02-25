import java.util.*;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] n, int k, int t) {
        TreeSet<Long> s=new TreeSet<>();
        for(int i=0;i<n.length;i++){
            Long x=(long)n[i];
            Long g=s.ceiling(x-(long)t);
            if(g!=null && g<=x+(long)t)return true;
            s.add(x);
            if(i>=k)s.remove((long)n[i-k]);
        }
        return false;
    }
}