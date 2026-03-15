class Solution {
    public int findRotateSteps(String r,String k){
        int n=r.length();
        Map<Character,List<Integer>> m=new HashMap<>();
        for(int i=0;i<n;i++) m.computeIfAbsent(r.charAt(i),x->new ArrayList<>()).add(i);
        int[][] d=new int[k.length()][n];
        for(int[] a:d) Arrays.fill(a,-1);
        return f(0,0,r,k,m,d);
    }
    int f(int i,int p,String r,String k,Map<Character,List<Integer>> m,int[][] d){
        if(i==k.length()) return 0;
        if(d[i][p]!=-1) return d[i][p];
        int n=r.length(),a=1<<30;
        for(int j:m.get(k.charAt(i))){
            int t=Math.abs(j-p);
            t=Math.min(t,n-t);
            a=Math.min(a,t+1+f(i+1,j,r,k,m,d));
        }
        return d[i][p]=a;
    }
}