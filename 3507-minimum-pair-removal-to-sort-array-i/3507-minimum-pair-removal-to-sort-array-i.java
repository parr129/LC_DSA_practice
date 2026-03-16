import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> a=new ArrayList<>();
        for(int x:nums)a.add(x);
        int ans=0;

        while(true){
            boolean ok=true;
            for(int i=1;i<a.size();i++) if(a.get(i)<a.get(i-1)) ok=false;
            if(ok) return ans;

            int idx=0,min=a.get(0)+a.get(1);
            for(int i=1;i<a.size()-1;i++){
                int s=a.get(i)+a.get(i+1);
                if(s<min){min=s;idx=i;}
            }

            a.set(idx,min);
            a.remove(idx+1);
            ans++;
        }
    }
}