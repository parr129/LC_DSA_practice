class Solution {
    public List<String> removeInvalidParentheses(String s){
        List<String> r=new ArrayList<>();
        Set<String> v=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(s);
        v.add(s);
        boolean f=false;
        while(!q.isEmpty()){
            String c=q.poll();
            if(g(c)){
                r.add(c);
                f=true;
            }
            if(f) continue;
            for(int i=0;i<c.length();i++){
                if(c.charAt(i)!='('&&c.charAt(i)!=')') continue;
                String n=c.substring(0,i)+c.substring(i+1);
                if(v.add(n)) q.add(n);
            }
        }
        return r;
    }
    boolean g(String s){
        int c=0;
        for(char x:s.toCharArray()){
            if(x=='(') c++;
            if(x==')'){
                if(c==0) return false;
                c--;
            }
        }
        return c==0;
    }
}