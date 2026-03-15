class Solution{
    public String nearestPalindromic(String n){
        long x=Long.parseLong(n);
        int l=n.length();
        Set<Long> s=new HashSet<>();
        s.add((long)Math.pow(10,l)+1);
        s.add((long)Math.pow(10,l-1)-1);
        long p=Long.parseLong(n.substring(0,(l+1)/2));
        for(long i=p-1;i<=p+1;i++){
            String a=""+i;
            String b=new StringBuilder(a.substring(0,l/2)).reverse().toString();
            s.add(Long.parseLong(a+b));
        }
        s.remove(x);
        long r=-1;
        for(long v:s)
            if(r==-1||Math.abs(v-x)<Math.abs(r-x)||Math.abs(v-x)==Math.abs(r-x)&&v<r)
                r=v;
        return ""+r;
    }
}