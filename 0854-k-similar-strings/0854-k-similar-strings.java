import java.util.*;

class Solution {
    public int kSimilarity(String s,String t){
        Queue<String> q=new LinkedList<>();
        Set<String> v=new HashSet<>();
        q.offer(s);
        v.add(s);
        int d=0;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                String c=q.poll();
                if(c.equals(t)) return d;
                int i=0;
                while(c.charAt(i)==t.charAt(i)) i++;
                char[] a=c.toCharArray();
                for(int j=i+1;j<a.length;j++){
                    if(a[j]==t.charAt(i)&&a[j]!=t.charAt(j)){
                        char tmp=a[i];a[i]=a[j];a[j]=tmp;
                        String nx=new String(a);
                        if(v.add(nx)) q.offer(nx);
                        tmp=a[i];a[i]=a[j];a[j]=tmp;
                    }
                }
            }
            d++;
        }
        return d;
    }
}