class Solution {
    public int ladderLength(String a,String b,List<String> w) {
        Set<String> s=new HashSet<>(w);
        if(!s.contains(b)) return 0;
        Queue<String> q=new LinkedList<>();
        q.offer(a);
        int l=1;
        while(!q.isEmpty()){
            int z=q.size();
            while(z-->0){
                String t=q.poll();
                char[] c=t.toCharArray();
                for(int i=0;i<c.length;i++){
                    char o=c[i];
                    for(char ch='a';ch<='z';ch++){
                        c[i]=ch;
                        String n=new String(c);
                        if(n.equals(b)) return l+1;
                        if(s.contains(n)){
                            q.offer(n);
                            s.remove(n);
                        }
                    }
                    c[i]=o;
                }
            }
            l++;
        }
        return 0;
    }
}
