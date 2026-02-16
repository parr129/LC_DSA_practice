import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> r=new ArrayList<>();
        f(0,a,new ArrayList<>(),r);
        return r;
    }
    void f(int i,int[] a,List<Integer> t,List<List<Integer>> r){
        r.add(new ArrayList<>(t));
        for(int j=i;j<a.length;j++){
            t.add(a[j]);
            f(j+1,a,t,r);
            t.remove(t.size()-1);
        }
    }
}
