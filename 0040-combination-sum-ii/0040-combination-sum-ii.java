import java.util.*;

class Solution {
    List<List<Integer>> r=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] a,int t){
        Arrays.sort(a);
        f(a,t,0,new ArrayList<>());
        return r;
    }
    void f(int[] a,int t,int i,List<Integer> l){
        if(t==0){ r.add(new ArrayList<>(l)); return; }
        for(int j=i;j<a.length&&a[j]<=t;j++){
            if(j>i&&a[j]==a[j-1]) continue;
            l.add(a[j]);
            f(a,t-a[j],j+1,l);
            l.remove(l.size()-1);
        }
    }
}