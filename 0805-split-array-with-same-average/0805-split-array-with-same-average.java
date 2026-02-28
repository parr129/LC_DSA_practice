import java.util.*;

class Solution {
    public boolean splitArraySameAverage(int[] a) {
        int n=a.length,s=0;
        for(int x:a) s+=x;
        Arrays.sort(a);
        List<Set<Integer>> dp=new ArrayList<>();
        for(int i=0;i<=n;i++) dp.add(new HashSet<>());
        dp.get(0).add(0);
        for(int x:a){
            for(int i=n-1;i>=1;i--){
                for(int y:dp.get(i-1)){
                    dp.get(i).add(y+x);
                }
            }
        }
        for(int k=1;k<=n/2;k++){
            if((s*k)%n==0 && dp.get(k).contains((s*k)/n)) return true;
        }
        return false;
    }
}