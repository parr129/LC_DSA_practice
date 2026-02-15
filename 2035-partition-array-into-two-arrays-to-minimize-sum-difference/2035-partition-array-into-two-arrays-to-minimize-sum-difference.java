import java.util.*;

class Solution {
    public int minimumDifference(int[] a) {
        int n=a.length/2;
        int[] l=Arrays.copyOfRange(a,0,n);
        int[] r=Arrays.copyOfRange(a,n,a.length);
        int s=0;
        for(int v:a) s+=v;
        List<List<Integer>> x=new ArrayList<>();
        List<List<Integer>> y=new ArrayList<>();
        for(int i=0;i<=n;i++){
            x.add(new ArrayList<>());
            y.add(new ArrayList<>());
        }
        for(int m=0;m<(1<<n);m++){
            int c=0,sl=0,sr=0;
            for(int i=0;i<n;i++){
                if((m&(1<<i))!=0){
                    c++;
                    sl+=l[i];
                    sr+=r[i];
                }
            }
            x.get(c).add(sl);
            y.get(c).add(sr);
        }
        for(int i=0;i<=n;i++) Collections.sort(y.get(i));
        int ans=Integer.MAX_VALUE;
        for(int k=0;k<=n;k++){
            List<Integer> p=x.get(k);
            List<Integer> q=y.get(n-k);
            for(int v:p){
                int t=s/2-v;
                int i=Collections.binarySearch(q,t);
                if(i<0) i=-i-1;
                if(i<q.size()){
                    int sum=v+q.get(i);
                    ans=Math.min(ans,Math.abs(s-2*sum));
                }
                if(i>0){
                    int sum=v+q.get(i-1);
                    ans=Math.min(ans,Math.abs(s-2*sum));
                }
            }
        }
        return ans;
    }
}
