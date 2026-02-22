import java.util.*;

class Solution {
    PriorityQueue<Integer> l=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> r=new PriorityQueue<>();
    Map<Integer,Integer> d=new HashMap<>();
    int ls=0,rs=0;

    public double[] medianSlidingWindow(int[] a,int k){
        int n=a.length;
        double[] ans=new double[n-k+1];
        for(int i=0;i<k;i++) add(a[i]);
        ans[0]=med();
        for(int i=k;i<n;i++){
            add(a[i]);
            rem(a[i-k]);
            ans[i-k+1]=med();
        }
        return ans;
    }

    void add(int x){
        if(l.isEmpty()||x<=l.peek()){l.offer(x);ls++;}
        else{r.offer(x);rs++;}
        bal();
    }

    void rem(int x){
        d.put(x,d.getOrDefault(x,0)+1);
        if(x<=l.peek()) ls--;
        else rs--;
        clean(l); clean(r);
        bal();
    }

    void bal(){
        if(ls>rs+1){r.offer(l.poll());ls--;rs++;clean(l);}
        else if(ls<rs){l.offer(r.poll());ls++;rs--;clean(r);}
    }

    void clean(PriorityQueue<Integer> q){
        while(!q.isEmpty()&&d.getOrDefault(q.peek(),0)>0){
            int x=q.poll();
            d.put(x,d.get(x)-1);
        }
    }

    double med(){
        if((ls+rs)%2==1) return l.peek();
        return ((long)l.peek()+r.peek())/2.0;
    }
}