import java.util.*;

class FreqStack {
    Map<Integer,Integer> f=new HashMap<>();
    Map<Integer,Deque<Integer>> g=new HashMap<>();
    int m=0;

    public void push(int x){
        int c=f.getOrDefault(x,0)+1;
        f.put(x,c);
        g.computeIfAbsent(c,k->new ArrayDeque<>()).push(x);
        m=Math.max(m,c);
    }

    public int pop(){
        int x=g.get(m).pop();
        f.put(x,f.get(x)-1);
        if(g.get(m).isEmpty()) m--;
        return x;
    }
}