class Solution {
    boolean p(long x){
        String s=""+x;
        int l=0,r=s.length()-1;
        while(l<r) if(s.charAt(l++)!=s.charAt(r--)) return false;
        return true;
    }

    public int superpalindromesInRange(String L,String R){
        long l=Long.parseLong(L),r=Long.parseLong(R);
        long m=(long)Math.sqrt(r);
        int c=0;

        for(int i=1;i<100000;i++){
            String s=""+i;

            long a=Long.parseLong(s+new StringBuilder(s).reverse());
            if(a<=m){
                long x=a*a;
                if(x>=l&&x<=r&&p(x)) c++;
            }

            long b=Long.parseLong(s+new StringBuilder(s.substring(0,s.length()-1)).reverse());
            if(b<=m){
                long x=b*b;
                if(x>=l&&x<=r&&p(x)) c++;
            }
        }
        return c;
    }
}